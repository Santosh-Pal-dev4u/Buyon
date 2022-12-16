package com.santosh.buyon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.santosh.buyon.login_frags.login;

public class Register_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        getSupportFragmentManager().beginTransaction().add(R.id.framelayout_registertion_activity,new login()).commit();
    }
}