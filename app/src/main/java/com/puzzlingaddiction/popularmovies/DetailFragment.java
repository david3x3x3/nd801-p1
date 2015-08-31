package com.puzzlingaddiction.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailFragment extends Fragment {

    private static final String LOG_TAG = DetailFragment.class.getSimpleName();

    private Movie mMovie;
    Context context;

    public DetailFragment() {
        this.context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);


        // The detail Activity called via intent.  Inspect the intent for forecast data.
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("movie")) {
            mMovie = (Movie)intent.getParcelableExtra("movie");
            String url = "http://image.tmdb.org/t/p/w185" + mMovie.getPosterPath();
            String title = mMovie.getTitle();
            String overview = mMovie.getOverview();
            ((TextView) rootView.findViewById(R.id.detail_title)).setText(title);
            Picasso.with(getActivity()).load(url).into(((ImageView) rootView.findViewById(R.id.detail_poster)));
            ((TextView) rootView.findViewById(R.id.detail_overview)).setText(mMovie.getOverview());
            ((TextView) rootView.findViewById(R.id.detail_release_date)).setText("Release Date: " + mMovie.getReleaseDate());
            ((TextView) rootView.findViewById(R.id.detail_vote_average)).setText("Average Rating: " + mMovie.getVoteAverage());
            //((TextView) rootView.findViewById(R.id.detail_popularity)).setText("Popularity: " + mMovie.getPopularity());
        }

        return rootView;
    }
}
