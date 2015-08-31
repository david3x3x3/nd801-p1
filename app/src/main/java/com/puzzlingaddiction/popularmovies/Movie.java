package com.puzzlingaddiction.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

/**
 * Created by David on 8/23/2015.
 */
public class Movie implements Parcelable {
    String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    String overview;

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    String posterPath;

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    String releaseDate;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    double voteAverage;

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    double popularity;

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Creator<Movie>() {
        public Movie createFromParcel(Parcel source) {
            Movie mMovie = new Movie();

            mMovie.title = source.readString();
            mMovie.overview = source.readString();
            mMovie.posterPath = source.readString();
            mMovie.releaseDate = source.readString();
            mMovie.voteAverage = source.readDouble();
            mMovie.popularity = source.readDouble();
            return mMovie;
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeString(posterPath);
        parcel.writeString(releaseDate);
        parcel.writeDouble(voteAverage);
        parcel.writeDouble(popularity);
    }

    public static Comparator<Movie> popularityComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie lhs, Movie rhs) {
            return -Double.compare(lhs.getPopularity(),rhs.getPopularity());
        }
    };

    public static Comparator<Movie> ratingComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie lhs, Movie rhs) {
            return -Double.compare(lhs.getVoteAverage(),rhs.getVoteAverage());
        }
    };
}