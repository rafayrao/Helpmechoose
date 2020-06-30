package com.matrimonialapp.helpmechoose.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.matrimonialapp.helpmechoose.Models.notifications;
import com.matrimonialapp.helpmechoose.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHoder> {

    Context context;
    List<notifications> listitem;
    public NotificationAdapter(Context context, List<notifications> listitem){
        this.context=context;
        this.listitem=listitem;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_listitem, parent, false);

        return new ViewHoder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {

        notifications list= listitem.get(position);
        holder.description.setText(list.getDescription());


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

            description=(TextView)itemView.findViewById(R.id.desp);
            imageView=(CircleImageView)itemView.findViewById(R.id.img);

        }
    }

}
