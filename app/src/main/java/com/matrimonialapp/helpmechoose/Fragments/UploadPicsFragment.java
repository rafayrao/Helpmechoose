package com.matrimonialapp.helpmechoose.Fragments;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.darsh.multipleimageselect.activities.AlbumSelectActivity;
import com.darsh.multipleimageselect.helpers.Constants;
import com.darsh.multipleimageselect.models.Image;
import com.erikagtierrez.multiple_media_picker.Gallery;
import com.fxn.pix.Options;
import com.fxn.pix.Pix;
import com.fxn.utility.PermUtil;
import com.matrimonialapp.helpmechoose.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class UploadPicsFragment extends Fragment {

    public static int READ_SINGLE_IMAGE = 1;
    public static int READ_MULTIPLE_IMAGE = 2;
    View view;
    Uri imageUri;
    Bitmap bitmap = null;
    ArrayList<String> selectedimage;
    ImageView image1_1, image2_1, image2_2, image3_1, image3_2, image3_3, image4_1, image4_2, image4_3, image4_4;
    RelativeLayout for1image;
    LinearLayout for2image, for3image, for4image;
    ImageView uploadimage, image;
      ArrayList<String> returnValue;
    ImageView uploadimageafter;
    int count=0;
    static final int OPEN_MEDIA_PICKER = 1;  // Request code

    public UploadPicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_upload_pics, container, false);
        initviews();
        uploadclick();
        uploadimageagain();

        return view;
    }

    private void uploadimageagain() {
    uploadimageafter.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(selectedimage.size()!=4) {
                selectimage();
            }
            else
            {
                Toast.makeText(getActivity(),"Cant select more than 4 pictures",Toast.LENGTH_SHORT).show();
            }
        }
    });
    }

    private void uploadclick() {
        uploadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

          selectimage();
            }
        });
    }

    private void selectimage()
    {
        Options options;
        options = Options.init()
                .setRequestCode(100)
                .setCount(4)
                .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT);
        Pix.start(getActivity(), options);

    }

    private void initviews() {
        image1_1 = (ImageView) view.findViewById(R.id.image1_1);
        image2_1 = (ImageView) view.findViewById(R.id.image2_1);
        image2_2 = (ImageView) view.findViewById(R.id.image2_2);
        image3_1 = (ImageView) view.findViewById(R.id.image3_1);
        image3_2 = (ImageView) view.findViewById(R.id.image3_2);
        image3_3 = (ImageView) view.findViewById(R.id.image3_3);
        image4_1 = (ImageView) view.findViewById(R.id.image4_1);
        image4_2 = (ImageView) view.findViewById(R.id.image4_2);
        image4_3 = (ImageView) view.findViewById(R.id.image4_3);
        image4_4 = (ImageView) view.findViewById(R.id.image4_4);

        for1image = view.findViewById(R.id.for1image);
        for2image = view.findViewById(R.id.for2image);
        for3image = view.findViewById(R.id.for3image);
        for4image = view.findViewById(R.id.for4image);


        selectedimage = new ArrayList<String>();
        image = (ImageView) view.findViewById(R.id.image);
        uploadimage = (ImageView) view.findViewById(R.id.uploadimage);
        uploadimageafter=view.findViewById(R.id.uploadimageafter);

        uploadimageafter.setVisibility(View.GONE);
        uploadimage.setVisibility(View.VISIBLE);

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == 100) {
            returnValue = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            selectedimage.addAll(returnValue);

        }

        if (selectedimage.size() == 1) {

            uploadimageafter.setVisibility(View.VISIBLE);
            uploadimage.setVisibility(View.GONE);
            for1image.setVisibility(View.VISIBLE);
            for2image.setVisibility(View.GONE);
            for3image.setVisibility(View.GONE);
            for4image.setVisibility(View.GONE);

            setimage(image1_1, String.valueOf(Uri.fromFile(new File(selectedimage.get(0)))));

        }
        if (selectedimage.size()== 2) {
            uploadimageafter.setVisibility(View.VISIBLE);
            uploadimage.setVisibility(View.GONE);
            for1image.setVisibility(View.GONE);
            for2image.setVisibility(View.VISIBLE);
            for3image.setVisibility(View.GONE);
            for4image.setVisibility(View.GONE);

            setimage(image2_1, String.valueOf(Uri.fromFile(new File(selectedimage.get(0)))));
            setimage(image2_2, String.valueOf(Uri.fromFile(new File(selectedimage.get(1)))));
        }

        if (selectedimage.size() == 3) {
            uploadimageafter.setVisibility(View.VISIBLE);
            uploadimage.setVisibility(View.GONE);
            for1image.setVisibility(View.GONE);
            for2image.setVisibility(View.GONE);
            for3image.setVisibility(View.VISIBLE);
            for4image.setVisibility(View.GONE);

            setimage(image3_1, String.valueOf(Uri.fromFile(new File(selectedimage.get(0)))));
            setimage(image3_2, String.valueOf(Uri.fromFile(new File(selectedimage.get(1)))));
            setimage(image3_3, String.valueOf(Uri.fromFile(new File(selectedimage.get(2)))));
        }
        if (selectedimage.size() == 4) {
            uploadimageafter.setVisibility(View.VISIBLE);
            uploadimage.setVisibility(View.GONE);
            for1image.setVisibility(View.GONE);
            for2image.setVisibility(View.GONE);
            for3image.setVisibility(View.GONE);
            for4image.setVisibility(View.VISIBLE);

            setimage(image4_1, String.valueOf(Uri.fromFile(new File(selectedimage.get(0)))));
            setimage(image4_2,String.valueOf(Uri.fromFile(new File(selectedimage.get(1)))));
            setimage(image4_3, String.valueOf(Uri.fromFile(new File(selectedimage.get(2)))));
            setimage(image4_4,String.valueOf(Uri.fromFile(new File(selectedimage.get(3)))));
        }
    }


    private  void setimage(ImageView imageView,String imageUri)
    {
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), Uri.parse(imageUri));
            Glide.with(getActivity()).load(bitmap).into(imageView);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PermUtil.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Pix.start(getActivity(), Options.init().setRequestCode(100));
                } else {
                    Toast.makeText(getActivity(), "Approve permissions to open Pix ImagePicker", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}

