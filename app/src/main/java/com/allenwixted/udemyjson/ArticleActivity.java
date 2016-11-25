package com.allenwixted.udemyjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by allenwixted on 24/11/2016.
 */

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_details);

        String title = getIntent().getStringExtra("title");

        TextView titleTV = (TextView) findViewById(R.id.textView);
        titleTV.setText(title);
    }
}
