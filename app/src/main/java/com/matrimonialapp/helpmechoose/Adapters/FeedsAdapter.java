package com.matrimonialapp.helpmechoose.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.matrimonialapp.helpmechoose.Models.FeedsModel;
import com.matrimonialapp.helpmechoose.Models.notifications;
import com.matrimonialapp.helpmechoose.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.ViewHoder> {

    Context context;
    List<FeedsModel> listitem;
    itemclickListener itemclickListener;

    public interface itemclickListener
    {
        public void onitemclick(FeedsModel model,int pos);
    }
    public FeedsAdapter(Context context, List<FeedsModel> listitem,itemclickListener itemclickListener){
        this.context=context;
        this.listitem=listitem;
        this.itemclickListener=itemclickListener;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.feeds_listitem, parent, false);

        return new ViewHoder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, final int position) {

        final FeedsModel list= listitem.get(position);
        holder.likes.setText(list.getLikes());
        holder.sidebar.setOnClickListener(new View.OnClickListener() {
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

        TextView likes;
        ImageView feedimg,sidebar;
        CircleImageView profileimg;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            sidebar=itemView.findViewById(R.id.sidebar);
            likes=itemView.findViewById(R.id.likes);
            feedimg=(ImageView) itemView.findViewById(R.id.feedimg);
            profileimg=(CircleImageView)itemView.findViewById(R.id.profileimg);

        }
    }

}
