package com.matrimonialapp.helpmechoose.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.matrimonialapp.helpmechoose.R;
import com.matrimonialapp.helpmechoose.Utils.Utils;


public class AddlocationFragment extends Fragment {

    View view;
    LinearLayout setlocation;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_addlocation, container, false);
        initviews();
        setlocationclick();
        return  view;
    }

    private void setlocationclick() {
        setlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.FragemntTransactionNormal(getActivity().getSupportFragmentManager(),R.id.container,new ShareSecurityFragment(),true,"Security Fragment");

            }
        });
    }

    private void initviews() {
        setlocation=view.findViewById(R.id.setlocation);

    }


}
