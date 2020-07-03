package com.matrimonialapp.helpmechoose.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.matrimonialapp.helpmechoose.Adapters.FeedsAdapter;
import com.matrimonialapp.helpmechoose.R;
import com.matrimonialapp.helpmechoose.Utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class MySharedPicVoteDescpFragment extends Fragment {

     View view;
    int lineCount_caption;
    TextView cation,seemorelink,seelesslink;
    ImageView image4_1,image4_2,image4_3,image4_4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_my_shared_pic_vote_descp, container, false);
        initviews();
        imageclicks();
        Captionsetting();
        return  view;
    }

    private void initviews() {
        image4_1=view.findViewById(R.id.image4_1);
        image4_2=view.findViewById(R.id.image4_2);
        image4_3=view.findViewById(R.id.image4_3);
        image4_4=view.findViewById(R.id.image4_4);

        cation=view.findViewById(R.id.cation);
        seemorelink=view.findViewById(R.id.seemorelink);
        seelesslink=view.findViewById(R.id.seelesslink);
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

    private void imageclicks() {
        image4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.FragemntTransactionNormal(getActivity().getSupportFragmentManager(),R.id.container,new EndVotesFragment(),true,"Endvotes Fragment");

            }
        });
        image4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.FragemntTransactionNormal(getActivity().getSupportFragmentManager(),R.id.container,new EndVotesFragment(),true,"Endvotes Fragment");

            }
        });

        image4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.FragemntTransactionNormal(getActivity().getSupportFragmentManager(),R.id.container,new EndVotesFragment(),true,"Endvotes Fragment");

            }
        });

        image4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.FragemntTransactionNormal(getActivity().getSupportFragmentManager(),R.id.container,new EndVotesFragment(),true,"Endvotes Fragment");

            }
        });
    }


}
