package com.matrimonialapp.helpmechoose.Fragments;


import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matrimonialapp.helpmechoose.Adapters.FeedsAdapter;
import com.matrimonialapp.helpmechoose.Adapters.NotificationAdapter;
import com.matrimonialapp.helpmechoose.Models.FeedsModel;
import com.matrimonialapp.helpmechoose.Models.notifications;
import com.matrimonialapp.helpmechoose.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedsFragment extends Fragment {

    RecyclerView recyclerView;
    List<FeedsModel> list;
    FeedsAdapter feedsAdapter;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_feeds, container, false);
        initviews();
        preparedata();
       return  view;
     }
    private void preparedata() {

        for(int i=0;i<10;i++)
        {

            list.add(new FeedsModel(R.drawable.mark,R.drawable.rao,"0 Likes"));
        }
        feedsAdapter=new FeedsAdapter(getActivity(), list, new FeedsAdapter.itemclickListener() {
            @Override
            public void onitemclick(FeedsModel model, int pos) {
                showsidebar();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(feedsAdapter);
    }

    private void showsidebar() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.sidebarpopup);
        dialog.setTitle("Title...");
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        // set the custom dialog components - text, image and button


        dialog.show();

    }

    private void initviews() {

        recyclerView=(RecyclerView)view.findViewById(R.id.feedrecycler);
        list=new ArrayList<>();
    }
}
