package com.allenwixted.udemyjson;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Collections;
import java.util.List;

/**
 * Created by allenwixted on 23/11/2016.
 */

public class Adapter extends RecyclerView.Adapter <Adapter.mViewHolder>{

    private LayoutInflater layoutInflator;
    List<Article> articleData = Collections.emptyList();

    public Adapter(Context context, List<Article> articleData){
        layoutInflator = LayoutInflater.from(context);
        this.articleData = articleData;
    }

    //every time new row is needed this is called
    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //view represents the root of the custom row
        View view = layoutInflator.inflate(R.layout.custom_row, parent, false);
        //pass the root to the view holder
        mViewHolder holder = new mViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {
        Article currentArticle = articleData.get(position);
        holder.title.setText(currentArticle.getTitle());
        holder.date.setText(currentArticle.getDate());
        holder.time.setText(currentArticle.getTime());
        holder.comments.setText(currentArticle.getComments());
        holder.views.setText(currentArticle.getViews());
        holder.thumbnailImage.setImageBitmap(currentArticle.getThumbnailImage());
    }

    @Override
    public int getItemCount() {
        return articleData.size();
    }

    public static class mViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView title;
        TextView time;
        TextView date;
        TextView views;
        TextView comments;
        ImageView thumbnailImage;
        ImageView bigImage;

        public mViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            time = (TextView) itemView.findViewById(R.id.time);
            date = (TextView) itemView.findViewById(R.id.date);
            views = (TextView) itemView.findViewById(R.id.views);
            comments= (TextView) itemView.findViewById(R.id.comments);
            thumbnailImage = (ImageView) itemView.findViewById(R.id.imageViewRV);
            //bigImage = (ImageView) itemView.findViewById(R.id.imageViewRV);
            thumbnailImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View itemView) {
            Log.i("CLICK", "CLICK" + getPosition());
            //move to new activity
            Context context = itemView.getContext();
            Intent showArticleIntent = new Intent(context, ArticleActivity.class);
            context.startActivity(showArticleIntent);
        }
    }
}
