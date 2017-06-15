package com.example.android.popularmoviesone.utility;

import com.example.android.popularmoviesone.Movies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Harshraj on 09-03-2017.
 */

public class QueryUtils {

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public static ArrayList<Movies> parseJson(String stringToBeParsed) throws JSONException {

        ArrayList<Movies> arrayListOfMovies = new ArrayList<Movies>();

        JSONObject forecastJson = new JSONObject(stringToBeParsed);

        JSONArray jsonArray = forecastJson.getJSONArray("results");

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject movieObject = jsonArray.getJSONObject(i);

            int movieId = movieObject.getInt("id");
            String movieTitle = movieObject.getString("title");
            String moviePoster = movieObject.getString("poster_path");
            String movieSynopsys = movieObject.getString("overview");
            String movieReleaseDate = movieObject.getString("release_date");
            double movieRating = movieObject.getDouble("vote_average");



            arrayListOfMovies.add(new Movies(movieId,movieTitle,moviePoster,movieSynopsys,movieReleaseDate,movieRating));



        }

        return arrayListOfMovies;
    }

}
