package com.matrimonialapp.helpmechoose.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matrimonialapp.helpmechoose.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyVotesFragment extends Fragment {


    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_my_votes, container, false);
        initviews();
        return  view;
    }

    private void initviews() {

    }

}
