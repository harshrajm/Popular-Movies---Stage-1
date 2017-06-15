package com.example.android.popularmoviesone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView imageViewPoster;
    TextView titleTV;
    TextView ratingTV;
    TextView relDateTV;
    TextView synTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Intent intent = getIntent();
        Movies movie  = (Movies) intent.getSerializableExtra("movie");

        //Toast.makeText(getApplicationContext(),movie.toString(), Toast.LENGTH_LONG).show();

        imageViewPoster = (ImageView) findViewById(R.id.iv_poster_mini);
        titleTV = (TextView) findViewById(R.id.tv_movie_title);
        ratingTV = (TextView) findViewById(R.id.tv_rating);
        relDateTV = (TextView) findViewById(R.id.tv_release_date);
        synTv = (TextView) findViewById(R.id.tv_synopsis);

        String baseUrl ="http://image.tmdb.org/t/p/w780";

        String fullUrl = baseUrl+movie.getPosterPath();

        Picasso.with(imageViewPoster.getContext())
                .load(fullUrl)
                .error(R.drawable.error)
                .placeholder(R.drawable.clapperboard)                     // optional*/
                .into(imageViewPoster);

        titleTV.setText(movie.getTitle());
        int rating = (int) movie.getUserRating();
        ratingTV.setText(String.valueOf(rating)+"/10");
        relDateTV.setText(movie.getReleaseDate());
        synTv.setText(movie.getSynopsis());


    }
}
