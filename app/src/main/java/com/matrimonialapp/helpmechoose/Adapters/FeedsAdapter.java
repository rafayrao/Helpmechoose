package com.matrimonialapp.helpmechoose.Adapters;

import android.content.Context;
import android.net.Uri;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.matrimonialapp.helpmechoose.LayoutedTextView;
import com.matrimonialapp.helpmechoose.Models.FeedsModel;
import com.matrimonialapp.helpmechoose.Models.notifications;
import com.matrimonialapp.helpmechoose.R;

import java.io.File;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.ViewHoder> {

    Context context;
    List<FeedsModel> listitem;
    itemclickListener itemclickListener;
    imageclickListener imageclickListener;
    int lineCount_caption;
    int linevount_comment;

    public interface itemclickListener
    {
        public void onitemclick(FeedsModel model,int pos);
    }

    public interface imageclickListener
    {
        public void onimageclick(FeedsModel model,int pos);
    }
    public FeedsAdapter(Context context, List<FeedsModel> listitem,itemclickListener itemclickListener,imageclickListener imageclickListener ){
        this.context=context;
        this.listitem=listitem;
        this.itemclickListener=itemclickListener;
        this.imageclickListener=imageclickListener;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.feeds_listitem, parent, false);

        return new ViewHoder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHoder holder, final int position) {

        final FeedsModel list= listitem.get(position);


        holder.likes.setText(list.getLikes());
        holder.cation.setText(list.getCaptions());
        holder.comment.setText(list.getComment());
        if (list.getBid() == 1) {

            holder.for1image.setVisibility(View.VISIBLE);
            holder.for2image.setVisibility(View.GONE);
            holder.for3image.setVisibility(View.GONE);
            holder.for4image.setVisibility(View.GONE);
            Glide.with(context).load(list.getImg1()).into(holder.image1_1);


        }
        if (list.getBid()== 2) {
            holder.for1image.setVisibility(View.GONE);
            holder. for2image.setVisibility(View.VISIBLE);
            holder.for3image.setVisibility(View.GONE);
            holder.for4image.setVisibility(View.GONE);
            Glide.with(context).load(list.getImg1()).into(holder.image2_1);
            Glide.with(context).load(list.getImg2()).into(holder.image2_2);

             }

        if (list.getBid() == 3) {
            holder.for1image.setVisibility(View.GONE);
            holder.for2image.setVisibility(View.GONE);
            holder.for3image.setVisibility(View.VISIBLE);
            holder. for4image.setVisibility(View.GONE);

            Glide.with(context).load(list.getImg1()).into(holder.image3_1);
            Glide.with(context).load(list.getImg2()).into(holder.image3_2);
            Glide.with(context).load(list.getImg3()).into(holder.image3_3);

         }
        if (list.getBid() == 4) {
            holder.for1image.setVisibility(View.GONE);
            holder.for2image.setVisibility(View.GONE);
            holder.for3image.setVisibility(View.GONE);
            holder.for4image.setVisibility(View.VISIBLE);

            Glide.with(context).load(list.getImg1()).into(holder.image4_1);
            Glide.with(context).load(list.getImg2()).into(holder.image4_2);
            Glide.with(context).load(list.getImg3()).into(holder.image4_3);
            Glide.with(context).load(list.getImg4()).into(holder.image4_4);

             }
        holder.cation.post(new Runnable() {
            @Override
            public void run() {
                Log.v("Line count: ",  holder.cation.getLineCount()+"");
                lineCount_caption= holder.cation.getLineCount();
                linevount_comment=holder.comment.getLineCount();

                /*for caption */
                if( lineCount_caption>2)
                {
                    holder.seemorelink.setVisibility(View.VISIBLE);
                    holder.seemorelink.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            holder.cation.setMaxLines(Integer.MAX_VALUE);
                            holder.seemorelink.setVisibility(View.GONE);
                            holder.seelesslink.setVisibility(View.VISIBLE);
                        }
                    });
                    holder.seelesslink.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            holder.cation.setEllipsize(TextUtils.TruncateAt.END);
                            holder.cation.setMaxLines(2);
                            holder.seemorelink.setVisibility(View.VISIBLE);
                            holder.seelesslink.setVisibility(View.GONE);

                        }
                    });
                }
                else {
                    holder.seemorelink.setVisibility(View.GONE);
                }


                /*for comment*/

                if( linevount_comment>2)
                {
                    holder.seemorelink_comment.setVisibility(View.VISIBLE);
                    holder.seemorelink_comment.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            holder.comment.setMaxLines(Integer.MAX_VALUE);
                            holder.seemorelink_comment.setVisibility(View.GONE);
                            holder.seelesslink_comment.setVisibility(View.VISIBLE);
                        }
                    });
                    holder.seelesslink_comment.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            holder.comment.setEllipsize(TextUtils.TruncateAt.END);
                            holder.comment.setMaxLines(2);
                            holder.seemorelink_comment.setVisibility(View.VISIBLE);
                            holder.seelesslink_comment.setVisibility(View.GONE);

                        }
                    });
                }
                else {
                    holder.seemorelink_comment.setVisibility(View.GONE);
                }
            }
        });

        Glide.with(context).load(list.getImg1()).into(holder.image4_1);
        Glide.with(context).load(list.getImg2()).into(holder.image4_2);
        Glide.with(context).load(list.getImg3()).into(holder.image4_3);
        Glide.with(context).load(list.getImg4()).into(holder.image4_4);
        holder.sidebar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemclickListener.onitemclick(list,position);
            }
        });
        holder.imageslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageclickListener.onimageclick(list,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public  class  ViewHoder extends RecyclerView.ViewHolder{

        RelativeLayout imageslayout;
        TextView likes;
        ImageView feedimg,sidebar,image4_1,image4_2,image4_3,image4_4,image3_1,image3_2,image3_3,image2_1,image2_2,image1_1;
        CircleImageView profileimg;
        LinearLayout for4image,for2image,for3image;
        RelativeLayout for1image;
        TextView cation,seemorelink,seelesslink,comment,seemorelink_comment,seelesslink_comment;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            sidebar=itemView.findViewById(R.id.sidebar);
            likes=itemView.findViewById(R.id.likes);
           // feedimg=(ImageView) itemView.findViewById(R.id.feedimg);

            imageslayout=itemView.findViewById(R.id.imageslayout);
           profileimg=(CircleImageView)itemView.findViewById(R.id.profileimg);
            image4_1=(ImageView)itemView.findViewById(R.id.image4_1);
            image4_2=(ImageView)itemView.findViewById(R.id.image4_2);
            image4_3=(ImageView)itemView.findViewById(R.id.image4_3);
            image4_4=(ImageView)itemView.findViewById(R.id.image4_4);

            image2_1=(ImageView)itemView.findViewById(R.id.image2_1);
            image2_2=(ImageView)itemView.findViewById(R.id.image2_2);


            image3_1=(ImageView)itemView.findViewById(R.id.image3_1);
            image3_2=(ImageView)itemView.findViewById(R.id.image3_2);
            image3_3=(ImageView)itemView.findViewById(R.id.image3_3);

            image1_1=(ImageView)itemView.findViewById(R.id.image1_1);

            for1image = itemView.findViewById(R.id.for1image);
            for2image = itemView.findViewById(R.id.for2image);
            for3image = itemView.findViewById(R.id.for3image);
            for4image=(LinearLayout)itemView.findViewById(R.id.for4image);


            cation=(TextView)itemView.findViewById(R.id.cation);
            seemorelink=(TextView)itemView.findViewById(R.id.seemorelink);
            seelesslink=(TextView)itemView.findViewById(R.id.seelesslink);
            comment=(TextView)itemView.findViewById(R.id.comment);
            seemorelink_comment=(TextView)itemView.findViewById(R.id.seemorelink_comment);
            seelesslink_comment=(TextView)itemView.findViewById(R.id.seelesslink_comment);

        }
    }

}
