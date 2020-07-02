package com.matrimonialapp.helpmechoose.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.matrimonialapp.helpmechoose.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SharePictureFragment extends Fragment {



    int lineCount_caption;
    View view;
    TextView cation,seemorelink,seelesslink;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_share_picture, container, false);
        initviews();
        Captionsetting();
        return  view;
    }


    private void initviews() {
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

}
