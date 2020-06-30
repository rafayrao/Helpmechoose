package com.matrimonialapp.helpmechoose.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.matrimonialapp.helpmechoose.Fragments.EditProfileFragment;
import com.matrimonialapp.helpmechoose.Fragments.FeedsFragment;
import com.matrimonialapp.helpmechoose.Fragments.MyProfileFragment;
import com.matrimonialapp.helpmechoose.Fragments.NotificationsFragment;
import com.matrimonialapp.helpmechoose.Fragments.ProfileFragment;
import com.matrimonialapp.helpmechoose.Fragments.SigninWithSocialMediaFragment;
import com.matrimonialapp.helpmechoose.Fragments.UploadPicsFragment;
import com.matrimonialapp.helpmechoose.R;
import com.matrimonialapp.helpmechoose.Utils.Utils;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    public  static  int code=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null)
        {   // getSupportActionBar().setTitle("Edit Profile");


            Utils.FragemntTransactionNormal(getSupportFragmentManager(),R.id.container,new FeedsFragment(),true,"Profile Fragment");
        }
        initviews();
           initclicks();
    }
    private void initviews() {

        bottomNavigation = findViewById(R.id.bottom_navigation);
    }
    private void initclicks() {

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.dashboard:
                       //      getSupportActionBar().setTitle("Matchedd Ride");
                        Utils.FragemntTransactionNormal(getSupportFragmentManager(),R.id.container,new FeedsFragment(),true,"FeedsFragment");

                        return true;

                    case R.id.notification:
                        Utils.FragemntTransactionNormal(getSupportFragmentManager(),R.id.container,new NotificationsFragment(),true,"NotificationFragment");


                        //        LoadFragment(new DownloadsFragment());
                        return true;


                    case R.id.camera:
                        Utils.FragemntTransactionNormal(getSupportFragmentManager(),R.id.container,
                                new UploadPicsFragment(),true,"UploadPicsFragment");
                        code=200;

                        //        LoadFragment(new DownloadsFragment());
                        return true;

                    case R.id.search:
                        Utils.FragemntTransactionNormal(getSupportFragmentManager(),R.id.container,new ProfileFragment(),true,"NotificationFragment");

          //              getSupportActionBar().setTitle("Settings");
                        return true;

                    case R.id.profile:
                        Utils.FragemntTransactionNormal(getSupportFragmentManager(),R.id.container,new MyProfileFragment(),true,"ProfileFragment");

                        code=100;

                        //            getSupportActionBar().setTitle("Settings");
                        return true;


                }
                return false;
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FragmentManager fragment = getSupportFragmentManager();
        if (fragment != null&&code==200) {
            fragment.findFragmentByTag("UploadPicsFragment").onActivityResult(requestCode, resultCode, data);
        }
        else if (fragment != null&&code==100) {
            fragment.findFragmentByTag("ProfileFragment").onActivityResult(requestCode, resultCode, data);
        }
        else {
            Utils.showToastMessage("Failed haha", this);
        }
    }

}
