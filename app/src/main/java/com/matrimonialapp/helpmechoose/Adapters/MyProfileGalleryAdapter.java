package com.matrimonialapp.helpmechoose.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.matrimonialapp.helpmechoose.Models.FeedsModel;
import com.matrimonialapp.helpmechoose.Models.UsergalleryimageModel;
import com.matrimonialapp.helpmechoose.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfileGalleryAdapter extends RecyclerView.Adapter<MyProfileGalleryAdapter.ViewHoder> {

    Context context;
    List<UsergalleryimageModel> listitem;
    itemclickListener itemclickListener;

    public MyProfileGalleryAdapter(Context context, List<UsergalleryimageModel> listitem,itemclickListener itemclickListener){
        this.context=context;
        this.listitem=listitem;
        this.itemclickListener= itemclickListener;
    }

    public interface itemclickListener
    {
        public void onitemclick(UsergalleryimageModel model, int pos);
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.usergallery_listitem, parent, false);

        return new ViewHoder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, final int position) {

        final UsergalleryimageModel list= listitem.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemclickListener.onitemclick(list,position);
            }
        });

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
