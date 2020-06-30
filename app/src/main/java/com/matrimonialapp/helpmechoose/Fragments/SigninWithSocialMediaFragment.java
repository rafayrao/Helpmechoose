package com.matrimonialapp.helpmechoose.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.matrimonialapp.helpmechoose.Activities.MainActivity;
import com.matrimonialapp.helpmechoose.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SigninWithSocialMediaFragment extends Fragment {

    View view;
    LinearLayout fbLogin;

    public SigninWithSocialMediaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_signin_with_social_media, container, false);
        initviews();
        fbclick();
        return  view;
    }

    private void fbclick() {
    fbLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivity(new Intent(getActivity(), MainActivity.class));
        }
    });
    }

    private void initviews() {
        fbLogin=(LinearLayout)view.findViewById(R.id.fbLogin);
    }

}
