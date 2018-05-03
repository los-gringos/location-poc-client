package com.kostas.retrofitexampleapplication.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kostas.retrofitexampleapplication.R;
import com.kostas.retrofitexampleapplication.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private int rowLayout;
    private List<Movie> movieList;
    private Context context;

    public MoviesAdapter(int rowLayout, List<Movie> movieList, Context context) {
        this.rowLayout = rowLayout;
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        holder.title.append(movieList.get(position).getTitle());
        holder.releaseDate.append(movieList.get(position).getReleaseDate());
        holder.popularity.append(Double.toString(movieList.get(position).getPopularity()));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MoviesViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout layout;
        TextView title;
        TextView popularity;
        TextView releaseDate;

        public MoviesViewHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.movieListItemLayout);
            title = itemView.findViewById(R.id.movieListItemTitleTextView);
            popularity = itemView.findViewById(R.id.movieListItemPopularityTextView);
            releaseDate = itemView.findViewById(R.id.movieListItemReleasedTextView);
        }
    }
}
