package com.santosh.buyon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class dashboard extends AppCompatActivity {

     BottomNavigationView bottomNavigationView;
    AlertDialog.Builder builder;

        HomeFragment homeFragment=new HomeFragment();
    ProfielFragment profielFragment=new ProfielFragment();
    add_to_cartFragment add_to_cartFragment=new add_to_cartFragment();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView=findViewById(R.id.bottom_navigation_bar);

        getSupportFragmentManager().beginTransaction().add(R.id.framelayout_dashboard_activity,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home_btn_bottom:
                         getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_dashboard_activity,homeFragment).commit();
                        break;

                    case R.id.cart_btn_bottom:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_dashboard_activity,add_to_cartFragment).commit();
                        break;

                    case R.id.profile_btn_bottom:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_dashboard_activity,profielFragment).commit();
                        break;


                }

             /*   builder = new AlertDialog.Builder(getActivity());
                builder.setIcon(R.drawable.ic_baseline_exit_to_app_24);
                builder.setTitle("Exit");
                builder.setMessage("Are you want to Exit?");

                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

*/

                return false;
            }
        });


    }
   /* @Override
    public void onBackPressed() {
        builder.show();
    }*/


}