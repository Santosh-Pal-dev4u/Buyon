package com.santosh.buyon.login_frags;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.santosh.buyon.R;


public class dont_have_account extends Fragment {

    EditText name_signup,mobile_signup,Email_signup,password_signup,confirm_signup;

    FirebaseAuth firebaseAuth;


    RequestQueue queue;
    StringRequest stringRequest;
    Button btn_register_signup;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dont_have_account, container, false);


        queue = Volley.newRequestQueue(getActivity());

        firebaseAuth=FirebaseAuth.getInstance();


        name_signup=view.findViewById(R.id.name_signup);
        mobile_signup=view.findViewById(R.id.mobile_signup);
        Email_signup=view.findViewById(R.id.Email_signup);
        password_signup=view.findViewById(R.id.password_signup);
        confirm_signup=view.findViewById(R.id.confirm_signup);
        btn_register_signup=view.findViewById(R.id.btn_register_signup);
        btn_register_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             String name=name_signup.getText().toString();
             String mobile=mobile_signup.getText().toString();
             String email=Email_signup.getText().toString();
             String password=password_signup.getText().toString();
                String Conf_password=confirm_signup.getText().toString();

             if(TextUtils.isEmpty(name) || TextUtils.isEmpty(mobile) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)|| TextUtils.isEmpty(Conf_password)){

                 Toast.makeText(getActivity(), "Input Valid Information", Toast.LENGTH_SHORT).show();
             }
             else {
                 firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {

                         if(task.isComplete()){

                             Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                             getFragmentManager().beginTransaction().replace(R.id.framelayout_registertion_activity, new login()).commit();

                         }
                         else {
                             Toast.makeText(getActivity(), "register Again you Are Valid User", Toast.LENGTH_SHORT).show();
                         }

                     }
                 });

             }







//                stringRequest = new StringRequest(Request.Method.GET, "http:www.santoshpal.link/WebService1.asmx/Register?name="+name+"&mobile="+mobile+"&email="+email+"&password="+password+"",
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                String rr=response;
//                                if(rr.equals("successfully inserted")) {
//                                    getFragmentManager().beginTransaction().replace(R.id.framelayout_registertion_activity, new login()).commit();
//                                }
//                                else {
//                                    Toast.makeText(getActivity(), "register Again you Are Valid User", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        }, new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getActivity(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                queue.add(stringRequest);




            }
        });



     return view;
    }
}