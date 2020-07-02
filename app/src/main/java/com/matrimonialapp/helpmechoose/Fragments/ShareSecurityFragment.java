package com.matrimonialapp.helpmechoose.Fragments;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.matrimonialapp.helpmechoose.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareSecurityFragment extends Fragment {


 View view;
 Spinner security_type,allowance_vote,mins,hours;
    int lineCount_caption;
    TextView cation,seemorelink,seelesslink;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_share_security, container, false);
       initviews();
       Captionsetting();
        ShowSpinner(getResources().getStringArray(R.array.security), security_type, 1);//my gender
        ShowSpinner(getResources().getStringArray(R.array.multiplevotes), allowance_vote, 2);//for marital status
        ShowSpinner(getResources().getStringArray(R.array.mins), mins, 3);//my gender
        ShowSpinner(getResources().getStringArray(R.array.hours), hours, 4);//for marital status

        return  view;
    }

    private void initviews() {

        cation=view.findViewById(R.id.cation);
        seemorelink=view.findViewById(R.id.seemorelink);
        seelesslink=view.findViewById(R.id.seelesslink);
        security_type=view.findViewById(R.id.security_type);
        allowance_vote=view.findViewById(R.id.allowance_vote);
        mins=view.findViewById(R.id.mins);
        hours=view.findViewById(R.id.hours);
    }


    private void ShowSpinner(String[] items, final Spinner spinner, final int spinnerid) {
        // Initializing a String Array
        String[] list = items;

        final List<String> plantsList = new ArrayList<>(Arrays.asList(list));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.support_simple_spinner_dropdown_item, plantsList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.parseColor("#C1C1C1"));
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                if (position > 0) {
                    Toast.makeText
                            (getActivity(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
