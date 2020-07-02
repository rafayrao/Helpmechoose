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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.matrimonialapp.helpmechoose.Adapters.FeedsAdapter;
import com.matrimonialapp.helpmechoose.Adapters.NotificationAdapter;
import com.matrimonialapp.helpmechoose.Models.FeedsModel;
import com.matrimonialapp.helpmechoose.Models.notifications;
import com.matrimonialapp.helpmechoose.R;
import com.matrimonialapp.helpmechoose.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedsFragment extends Fragment {

    RecyclerView recyclerView;
    List<FeedsModel> list;
    FeedsAdapter feedsAdapter;
    LinearLayout for4image;
    View view;
    TextView myvotes;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_feeds, container, false);
        initviews();
        preparedata();
        myvotesclick();
       return  view;
     }

    private void myvotesclick() {
        myvotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.FragemntTransactionNormal(getActivity().getSupportFragmentManager(),R.id.container,new MyVotesFragment(),true,"Myvotes Fragment");

            }
        });
    }

    private void preparedata() {

        for(int i=0;i<10;i++)
        {

            list.add(new FeedsModel(R.drawable.mark,R.drawable.marklarge,R.drawable.mraksmall,R.drawable.mraksmall,R.drawable.mraksmall,R.drawable.mraksmall,"100 Likes","" +
                    "It's natural to want to share your happiness with others. Whether you're flashing a genuine smile in a selfie or capturing the incredible beauty of a sunset in your post, a good quote that captures the joy and happiness you're feeling can be contagious to your followers.","nice caption ,great to here from you .You are the truely inspiration for the young generation.I wish i would meet you atleast once"));
        }
        feedsAdapter=new FeedsAdapter(getActivity(), list, new FeedsAdapter.itemclickListener() {
            @Override
            public void onitemclick(FeedsModel model, int pos) {
                showsidebar();
            }
        }, new FeedsAdapter.imageclickListener() {
            @Override
            public void onimageclick(FeedsModel model, int pos) {
                Utils.FragemntTransactionNormal(getActivity().getSupportFragmentManager(),R.id.container,new ShowImageForVotingFragment(),true,"Imagefor votings Fragment");

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
        ImageView share = (ImageView) dialog.findViewById(R.id.share);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.FragemntTransactionNormal(getActivity().getSupportFragmentManager(),R.id.container,new SharePictureFragment(),true,"SharepicFragment");
                dialog.dismiss();
            }
        });


        dialog.show();

    }

    private void initviews() {
        myvotes=view.findViewById(R.id.myvotes);
        for4image=view.findViewById(R.id.for4image);
        recyclerView=(RecyclerView)view.findViewById(R.id.feedrecycler);
        list=new ArrayList<>();
    }
}
