package com.puzzlingaddiction.popularmovies;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private final String LOG_TAG = MovieAdapter.class.getSimpleName();

    Context context;
    ArrayList<Movie> mMovieList;

    public MovieAdapter(Context context, ArrayList<Movie> items) {
        this.context = context;
        mMovieList = items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            imageView = (ImageView) inflater.inflate(R.layout.grid_item_movie, null);
        } else {
            imageView = (ImageView) convertView;
        }
        Movie movie = mMovieList.get(position);

        String url = "http://image.tmdb.org/t/p/w185" + movie.getPosterPath();
        String title = movie.getTitle();

        Picasso.with(context).load(url).into((ImageView)imageView);

        return imageView;
    }

    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
