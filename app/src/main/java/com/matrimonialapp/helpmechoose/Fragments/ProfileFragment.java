package com.matrimonialapp.helpmechoose.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matrimonialapp.helpmechoose.Adapters.FeedsAdapter;
import com.matrimonialapp.helpmechoose.Adapters.UserGalleryAdapter;
import com.matrimonialapp.helpmechoose.Models.FeedsModel;
import com.matrimonialapp.helpmechoose.Models.UsergalleryimageModel;
import com.matrimonialapp.helpmechoose.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    RecyclerView recyclerView;
    List<UsergalleryimageModel> list;
    UserGalleryAdapter userGalleryAdapter;
    View view;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_profile, container, false);
        initviews();
        preparedata();
        return view;
    }
    private void preparedata() {

        for(int i=0;i<30;i++)
        {

            list.add(new UsergalleryimageModel(R.drawable.mark));
        }
        userGalleryAdapter=new UserGalleryAdapter(getActivity(), list);
   //     LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        recyclerView.setAdapter(userGalleryAdapter);
    }
    private void initviews() {

        recyclerView=(RecyclerView)view.findViewById(R.id.usergallery);
        list=new ArrayList<>();
    }
}
