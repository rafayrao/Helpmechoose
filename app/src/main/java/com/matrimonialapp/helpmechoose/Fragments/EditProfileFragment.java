package com.matrimonialapp.helpmechoose.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.matrimonialapp.helpmechoose.R;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditProfileFragment extends Fragment  implements IPickResult {

View view;
ImageView profileimg;
    public EditProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      view=inflater.inflate(R.layout.fragment_edit_profile, container, false);
      initviews();
      uploadpic();
        return view;
    }

    private void uploadpic() {
   profileimg.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           PickImageDialog.build(new PickSetup()).show(getActivity());

       }
   });
    }

    private void initviews() {
        profileimg=view.findViewById(R.id.profileimg);
    }

    @Override
    public void onPickResult(PickResult r) {
        if (r.getError() == null) {
            //If you want the Uri.
            //Mandatory to refresh image from Uri.
            //getImageView().setImageURI(null);

            //Setting the real returned image.
            //getImageView().setImageURI(r.getUri());

            //If you want the Bitmap.
          profileimg.setImageBitmap(r.getBitmap());

            //Image path
            //r.getPath();
        } else {
            //Handle possible errors
            //TODO: do what you have to do with r.getError();
            Toast.makeText(getActivity(), r.getError().getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
