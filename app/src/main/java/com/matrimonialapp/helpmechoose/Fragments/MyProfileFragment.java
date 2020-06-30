package com.matrimonialapp.helpmechoose.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.matrimonialapp.helpmechoose.Adapters.MyProfileGalleryAdapter;
import com.matrimonialapp.helpmechoose.Adapters.UserGalleryAdapter;
import com.matrimonialapp.helpmechoose.Models.UsergalleryimageModel;
import com.matrimonialapp.helpmechoose.R;
import com.matrimonialapp.helpmechoose.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {

View view;
    RecyclerView recyclerView;
    List<UsergalleryimageModel> list;
    MyProfileGalleryAdapter userGalleryAdapter;

    RelativeLayout editprofile_btn;
    public MyProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_my_profile, container, false);
        initviews();
        preparedata();
        editprofilebtnclick();
        return view;
    }

    private void editprofilebtnclick() {
    editprofile_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Utils.FragemntTransactionNormal(getActivity().getSupportFragmentManager(),R.id.container,new EditProfileFragment(),true,"EditProfileFragment");

        }
    });
    }

    private void initviews() {
        editprofile_btn=view.findViewById(R.id.editprofile_btn);
        recyclerView=(RecyclerView)view.findViewById(R.id.usergallery);
        list=new ArrayList<>();

    }
    private void preparedata() {

        for(int i=0;i<30;i++)
        {

            list.add(new UsergalleryimageModel(R.drawable.mark));
        }
        userGalleryAdapter=new MyProfileGalleryAdapter(getActivity(), list);
        //     LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        recyclerView.setAdapter(userGalleryAdapter);
    }

}
