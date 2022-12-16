package com.santosh.buyon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class ProfielFragment extends Fragment {



    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;
    SharedPreferences sharedPreferences;

    ImageView profile_image;
    TextView txt_logout,txt_user_name;
    RecyclerView recycler_view_profile_items;
    String list[]={"Setting","Language","Payment Methods","Contact Us"};
    int img[]={R.drawable.settings_24,R.drawable.language_24,R.drawable.payments_24,R.drawable.support_24};

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profiel, container, false);



        sharedPreferences= getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        profile_image=view.findViewById(R.id.profile_image);
        txt_user_name=view.findViewById(R.id.txt_user_name);
        txt_logout=view.findViewById(R.id.txt_logout);
        recycler_view_profile_items=view.findViewById(R.id.recycler_view_profile_items);
        profile_recyler_adapter profile_recyler_adapter=new profile_recyler_adapter(getActivity(),list,img);
        recycler_view_profile_items.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recycler_view_profile_items.setAdapter(profile_recyler_adapter);




        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);



        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            txt_user_name.setText(personName);
            Glide.with(getActivity()).load(String.valueOf(personPhoto)).into(profile_image);



        }

        txt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.apply();
                editor.remove("session");
                getActivity().finish();
                revokeAccess();

            }
        });


        return view;
        }


    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getActivity(), "Loging Out ", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void revokeAccess() {
        mGoogleSignInClient.revokeAccess()
                .addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });
    }
}