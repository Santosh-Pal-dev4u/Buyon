package com.santosh.buyon.login_frags;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.santosh.buyon.R;
import com.santosh.buyon.Register_page;
import com.santosh.buyon.dashboard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;


public class login extends Fragment {

    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;
    private final int RC_SIGN_IN = 1000;

    CallbackManager callbackManager;
    SharedPreferences sharedPreferences;
    RequestQueue queue;
    StringRequest stringRequest;


    FirebaseAuth firebaseAuth;


    LottieAnimationView google_login,fb_login;
     Button login_btn;
    TextView dont_have_acc;
    EditText Email_login,password_login;

    /*   TextView txt_forget_password;*/
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        FacebookSdk.sdkInitialize(getContext());

        queue = Volley.newRequestQueue(getActivity());

/*

        txt_forget_password= txt_forget_password.findViewById(R.id.txt_forget_password);
*/

        firebaseAuth=FirebaseAuth.getInstance();

        Email_login=view.findViewById(R.id.Email_login);
        password_login=view.findViewById(R.id.password_login);
        login_btn=view.findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=Email_login.getText().toString();
                String password=password_login.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(getActivity(), "Please enter Email and Password", Toast.LENGTH_SHORT).show();

                }
                else {
                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(getActivity(), new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {


                            Intent inn = new Intent(getActivity(),dashboard.class);
                            startActivity(inn);




                            Email_login.setText("");
                            password_login.setText("");
                        }
                    });


                }




              /*  stringRequest = new StringRequest(Request.Method.GET, "http://www.santoshpal.link/WebService1.asmx/Login?email="+email+"&password="+password,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONArray jsonArray=new JSONArray(response);
                                    JSONObject jsonObject=jsonArray.getJSONObject(0);
                                    String ms=jsonObject.getString("msg");

                                   // Toast.makeText(getActivity(), ""+ms, Toast.LENGTH_SHORT).show();
                                 if(ms.equals("1")){
                                      Intent inn = new Intent(getActivity(),dashboard.class);
                                        startActivity(inn);

                                       // Toast.makeText(getActivity(), "Invalid User", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(getActivity(), "Invalid User", Toast.LENGTH_SHORT).show();
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                queue.add(stringRequest);
*/

            }
        });

        fb_login=view.findViewById(R.id.lottie_fb_icon_signup_page);

        dont_have_acc = view.findViewById(R.id.dont_Have_an_Account_textview);
        dont_have_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.framelayout_registertion_activity, new dont_have_account()).addToBackStack(null).commit();
            }
        });


        // fb login



        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {

                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        /*Intent inn = new Intent(getActivity(),dashboard.class);
                        startActivity(inn);*/

                        GraphRequest request = GraphRequest.newMeRequest(

                                loginResult.getAccessToken(),

                                new GraphRequest.GraphJSONObjectCallback() {

                                    @Override
                                    public void onCompleted(JSONObject object,
                                                            GraphResponse response)
                                    {

                                        if (object != null) {
                                            try {
                                                String name = object.getString("name");
                                                String email = object.getString("email");
                                                String fbUserID = object.getString("id");

                                                Toast.makeText(getContext(), ""+name+" "+email+" "+fbUserID, Toast.LENGTH_SHORT).show();

                                                //disconnectFromFacebook();

                                                // do action after Facebook login success
                                                // or call your API
                                            }
                                            catch (JSONException | NullPointerException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                });

                        Bundle parameters = new Bundle();
                        parameters.putString(
                                "fields",
                                "id, name, email, gender, birthday");
                        request.setParameters(parameters);
                        request.executeAsync();

                    }

                    @Override
                    public void onCancel() {
                        // App code
                        Log.v("LoginScreen", "---onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // here write code when get error
                        Log.v("LoginScreen", "----onError: "
                                + exception.getMessage());
                    }
                 });

              fb_login.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {

                      LoginManager.getInstance().logInWithReadPermissions(getActivity(), Arrays.asList("public_profile"));
                  }
              });



       ///




        sharedPreferences= getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        String id=sharedPreferences.getString("session","0");

        if(id!="0"){

            Intent inn = new Intent(getActivity(),dashboard.class);
            startActivity(inn);

        }



// google login
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getActivity());

        google_login = view.findViewById(R.id.lottie_google_icon_signup_page);
        google_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


        return view;
    }





    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("session",""+personId);
                editor.apply();

                Intent in = new Intent(getActivity(),dashboard.class);
                startActivity(in);


            }


        } catch (ApiException e) {
            Log.d("signInResult:failed code=" , e.toString());

        }






    }


}