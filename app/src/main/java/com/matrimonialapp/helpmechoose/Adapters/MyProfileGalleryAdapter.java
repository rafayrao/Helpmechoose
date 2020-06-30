package com.matrimonialapp.helpmechoose.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.matrimonialapp.helpmechoose.Models.UsergalleryimageModel;
import com.matrimonialapp.helpmechoose.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfileGalleryAdapter extends RecyclerView.Adapter<MyProfileGalleryAdapter.ViewHoder> {

    Context context;
    List<UsergalleryimageModel> listitem;
    public MyProfileGalleryAdapter(Context context, List<UsergalleryimageModel> listitem){
        this.context=context;
        this.listitem=listitem;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.usergallery_listitem, parent, false);

        return new ViewHoder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {

        UsergalleryimageModel list= listitem.get(position);


    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public  class  ViewHoder extends RecyclerView.ViewHolder{

        TextView description;
        CircleImageView imageView;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);


        }
    }

}
