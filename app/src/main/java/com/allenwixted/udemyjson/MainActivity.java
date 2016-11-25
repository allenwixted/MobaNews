package com.allenwixted.udemyjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    public static Adapter adapter;
    DownloadTask task;
    static ArrayList<Article> data;

    public static ArrayList<Article> getData() {

        return data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task = new DownloadTask();
        data = task.articlesArray;
        task.execute("http://www.mobanode.mobi/ex/news.json");

        recyclerView = (RecyclerView) findViewById(R.id.articleListRV);
        adapter = new Adapter(getBaseContext(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
    }
}
