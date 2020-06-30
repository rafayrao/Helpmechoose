package com.matrimonialapp.helpmechoose.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matrimonialapp.helpmechoose.Adapters.NotificationAdapter;
import com.matrimonialapp.helpmechoose.Models.notifications;
import com.matrimonialapp.helpmechoose.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationsFragment extends Fragment {


    RecyclerView recyclerView;
    List<notifications> list;
    NotificationAdapter notificationAdapter;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_notifications, container, false);
        initviews();
        preparedata();
        return  view;
    }
    private void preparedata() {

        for(int i=0;i<10;i++)
        {

            list.add(new notifications(R.drawable.mark,"Rao commented on your photo"));
        }
        notificationAdapter=new NotificationAdapter(getActivity(),list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(notificationAdapter);
    }

    private void initviews() {

        recyclerView=(RecyclerView)view.findViewById(R.id.notirecycler);
        list=new ArrayList<>();
    }

}
