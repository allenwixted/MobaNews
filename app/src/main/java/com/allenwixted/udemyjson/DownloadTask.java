package com.allenwixted.udemyjson;


import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by allenwixted on 23/11/2016.
 */

public class DownloadTask extends AsyncTask<String, Void, String> {

    public ArrayList<Article> articlesArray = new ArrayList<>();

    private RecyclerView recyclerView;


    @Override
    protected String doInBackground(String... urls) {

        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;

        try {
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream input = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);
            int data = reader.read();

            //append and read characters
            while(data != -1){
                char currentCharacter = (char) data;
                result += currentCharacter;
                data = reader.read();
            }

            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //called when doInBackground is completed and passed the result
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        try {
            JSONArray jsonArray = new JSONArray(result);

            for(int x = 0; x < jsonArray.length(); x++){

                JSONObject jsonPart = jsonArray.getJSONObject(x);

                Article newArticle = new Article();
                newArticle.setTitle(jsonPart.getString("title"));
                newArticle.setAuthor(jsonPart.getString("author"));
                newArticle.setDate(jsonPart.getInt("published_at"));
                newArticle.setTime(jsonPart.getInt("published_at"));
                newArticle.setViews(jsonPart.getInt("views"));
                newArticle.setComments(jsonPart.getInt("comments"));
                newArticle.setThumbnail(jsonPart.getString("thumb"));
                newArticle.setPhoto(jsonPart.getString("image"));
                newArticle.setBody(jsonPart.getString("article_body"));

                articlesArray.add(x, newArticle);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MainActivity.adapter.notifyDataSetChanged();
    }
}