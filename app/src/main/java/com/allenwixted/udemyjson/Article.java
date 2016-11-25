package com.allenwixted.udemyjson;

import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ImageView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by allenwixted on 23/11/2016.
 */

public class Article {
    private String title;
    private String author;
    private String date;
    private String views;
    private String comments;
    private String thumbnail;
    private String photo;
    private String body;
    private String time;
    private Bitmap thumbnailImage;
    private Bitmap bigImage;

    public void setThumbnailImage(Bitmap aThumbnailImage){
        thumbnailImage = aThumbnailImage;
    }

    public void setBigImage(Bitmap aBitmap){
        bigImage = aBitmap;
    }

    public void setTitle(String aTitle){
        title = aTitle;
    }

    public void setAuthor(String aAuthor){
        author = aAuthor;
    }

    public void setDate(long aDate){
        Date dateToFormat = new Date(aDate*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy"); // the format of the date
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String formattedDate = sdf.format(dateToFormat);
        date = formattedDate;
        Log.i("DATE DATE DATE", formattedDate);
    }

    public void setTime(long aDate){
        Date timeToFormat = new Date(aDate*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // the format of the date
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String formattedTime = sdf.format(timeToFormat);
        time = formattedTime;
        Log.i("TIME TIME TIME", time);
    }

    public void setViews(int aView){
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String yourFormattedNumber= formatter.format(aView);
        views = String.valueOf(yourFormattedNumber);
    }

    public void setComments(int aComment){
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String yourFormattedComment= formatter.format(aComment);
        comments = String.valueOf(yourFormattedComment);
    }

    public void setThumbnail(String aThumb){
        thumbnail = aThumb;
    }

    public void setPhoto(String aPhoto){
        photo = aPhoto;
    }

    public void setBody(String aBody){
        body = aBody;
    }


    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getDate(){
        return date;
    }

    public String getViews(){
        return views;
    }

    public String getComments(){
        return comments;
    }

    public String getThumbnail(){
        return thumbnail;
    }

    public String getPhoto(){
        return photo;
    }

    public String getBody(){
        return body;
    }

    public String getTime() {
        return time;
    }

    public Bitmap getThumbnailImage(){
        return thumbnailImage;
    }

    public Bitmap getBigImage(){
        return bigImage;
    }
}
