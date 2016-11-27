package com.allenwixted.udemyjson;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by allenwixted on 24/11/2016.
 */

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_details);

        String title = getIntent().getStringExtra("Title");
        String author = getIntent().getStringExtra("Author");
        String date = getIntent().getStringExtra("Date");
        String views = getIntent().getStringExtra("Views");
        String comments = getIntent().getStringExtra("Comments");
        String body = getIntent().getStringExtra("Body");
        String time = getIntent().getStringExtra("Time");
        String image = getIntent().getStringExtra("Image");

        TextView titleTV = (TextView) findViewById(R.id.articleTitle);
        TextView authorTV = (TextView) findViewById(R.id.articleAuthor);
        TextView dateTV = (TextView) findViewById(R.id.articleDate);
        TextView viewsTV = (TextView) findViewById(R.id.articleViews);
        TextView commentsTV = (TextView) findViewById(R.id.articleComments);
        TextView bodyTV = (TextView) findViewById(R.id.articleBody);
        TextView timeTV = (TextView) findViewById(R.id.articleTime);
        ImageView imageTV = (ImageView) findViewById(R.id.articleImageView);


        titleTV.setText(title);
        authorTV.setText("Author: " + author);
        dateTV.setText("Date: " + date);
        viewsTV.setText("Views: " + views);
        commentsTV.setText("Comments: " +comments);
        bodyTV.setText(body);
        timeTV.setText("Time: " + time);
        //imageTV.setImageBitmap(image);
        Picasso.with(this).load(image).into(imageTV);
    }
}
