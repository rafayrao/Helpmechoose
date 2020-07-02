package com.matrimonialapp.helpmechoose.Fragments;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    int lineCount_caption;
    RecyclerView recyclerView;
    RelativeLayout votes_txt,votes_txt2,votes_txt3,votes_txt4;
   // List<UsergalleryimageModel> list;
//    UserGalleryAdapter userGalleryAdapter;
    TextView cation,seemorelink,seelesslink;
    ImageView image4_1,image4_2,image4_3,image4_4;
    LinearLayout image1back,image2back,image3back,image4back;
    int imageselected1=0;
    int imageselected2=0;
    int imageselected3=0;
    int imageselected4=0;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_profile, container, false);
        initviews();
        Captionsetting();
        imageselection();
 //       preparedata();
        return view;
    }



    /*   private void preparedata() {

           for(int i=0;i<30;i++)
           {

               list.add(new UsergalleryimageModel(R.drawable.mark));
           }
           userGalleryAdapter=new UserGalleryAdapter(getActivity(), list);
      //     LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
           recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

           recyclerView.setAdapter(userGalleryAdapter);
       }*/
    private void initviews() {
        image4_1=(ImageView)view.findViewById(R.id.image4_1);
        image4_2=(ImageView)view.findViewById(R.id.image4_2);
        image4_3=(ImageView)view.findViewById(R.id.image4_3);
        image4_4=(ImageView)view.findViewById(R.id.image4_4);

        image1back=(LinearLayout)view.findViewById(R.id.image1back);
        image2back=(LinearLayout)view.findViewById(R.id.image2back);
        image3back=(LinearLayout)view.findViewById(R.id.image3back);
        image4back=(LinearLayout)view.findViewById(R.id.image4back);

        votes_txt=view.findViewById(R.id.votes_txt);
        votes_txt2=view.findViewById(R.id.votes_txt2);
        votes_txt3=view.findViewById(R.id.votes_txt3);
        votes_txt4=view.findViewById(R.id.votes_txt4);

        cation=view.findViewById(R.id.cation);
        seemorelink=view.findViewById(R.id.seemorelink);
        seelesslink=view.findViewById(R.id.seelesslink);
        recyclerView=(RecyclerView)view.findViewById(R.id.usergallery);
       // list=new ArrayList<>();
    }

    private void imageselection() {
        image4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageselected1==0)
                {
                    image1back.setBackgroundColor(Color.parseColor("#80000000"));
                    votes_txt.setVisibility(View.VISIBLE);
                    imageselected1=1;
                }
                else
                {
                    image1back.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    votes_txt.setVisibility(View.GONE);
                    imageselected1=0;
                }
            }
        });

        image4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(imageselected2==0)
                {
                    image2back.setBackgroundColor(Color.parseColor("#80000000"));
                    votes_txt2.setVisibility(View.VISIBLE);
                    imageselected2=1;
                }
                else
                {
                    image2back.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    votes_txt2.setVisibility(View.GONE);
                    imageselected2=0;
                }
            }
        });

        image4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageselected3==0)
                {
                    image3back.setBackgroundColor(Color.parseColor("#80000000"));
                    votes_txt3.setVisibility(View.VISIBLE);
                    imageselected3=1;
                }
                else
                {
                    image3back.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    votes_txt3.setVisibility(View.GONE);
                    imageselected3=0;
                }
            }
        });


        image4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageselected4==0)
                {
                    image4back.setBackgroundColor(Color.parseColor("#80000000"));
                    votes_txt4.setVisibility(View.VISIBLE);
                    imageselected4=1;
                }
                else
                {
                    image4back.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    votes_txt4.setVisibility(View.GONE);
                    imageselected4=0;
                }
            }
        });
    }
    private void Captionsetting() {
        cation.post(new Runnable() {
            @Override
            public void run() {
                Log.v("Line count: ", cation.getLineCount()+"");
                lineCount_caption= cation.getLineCount();

                /*for caption */
                if( lineCount_caption>2)
                {
                    seemorelink.setVisibility(View.VISIBLE);
                    seemorelink.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            cation.setMaxLines(Integer.MAX_VALUE);
                            seemorelink.setVisibility(View.GONE);
                            seelesslink.setVisibility(View.VISIBLE);
                        }
                    });
                    seelesslink.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            cation.setEllipsize(TextUtils.TruncateAt.END);
                            cation.setMaxLines(2);
                            seemorelink.setVisibility(View.VISIBLE);
                            seelesslink.setVisibility(View.GONE);

                        }
                    });
                }
                else {
                    seemorelink.setVisibility(View.GONE);
                }
            }
        });
    }
}
