package com.matrimonialapp.helpmechoose.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.matrimonialapp.helpmechoose.Fragments.SigninWithSocialMediaFragment;
import com.matrimonialapp.helpmechoose.R;
import com.matrimonialapp.helpmechoose.Utils.Utils;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


            Utils.FragemntTransactionNormal(getSupportFragmentManager(),R.id.registration_container,new SigninWithSocialMediaFragment(),true,"Profile Fragment");

    }
}
