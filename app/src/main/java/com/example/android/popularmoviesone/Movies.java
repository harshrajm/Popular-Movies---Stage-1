package com.example.android.popularmoviesone;

import java.io.Serializable;

/**
 * Created by Harshraj on 09-03-2017.
 */

public class Movies implements Serializable {

    private int id;
    private String title;
    private String posterPath;
    private String synopsis;
    private double userRating;
    private String releaseDate;


    public Movies(int id, String title, String posterPath, String synopsis, String releaseDate, double userRating) {
        this.id = id;
        this.title = title;
        this.posterPath = posterPath;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
        this.userRating = userRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", userRating=" + userRating +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
