package com.vinaykumar.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vinaykumar.myapplication.R;
import com.vinaykumar.myapplication.databinding.RowMovieListBinding;
import com.vinaykumar.myapplication.model.Movies;
import com.vinaykumar.myapplication.view.MovieDetailedActivity;
import com.vinaykumar.myapplication.viewmodel.MoviesViewModel;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {


    Context context;
    ArrayList<Movies> moviesArrayList;

    public MoviesAdapter(Context context, ArrayList<Movies> moviesArrayList) {
        this.context = context;
        this.moviesArrayList = moviesArrayList;
    }

    @NonNull
    @Override
    public MoviesAdapter.MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        return null;
        RowMovieListBinding rowMovieListBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),R.layout.row_movie_list,viewGroup,false);
        return new MoviesViewHolder(rowMovieListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.MoviesViewHolder moviesViewHolder, int i) {
        Movies movie = moviesArrayList.get(i);
        moviesViewHolder.rowMovieListBinding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return moviesArrayList.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {

        private RowMovieListBinding rowMovieListBinding;

        public MoviesViewHolder(RowMovieListBinding rowMovieListBinding) {
            super(rowMovieListBinding.getRoot());
            this.rowMovieListBinding = rowMovieListBinding;

            rowMovieListBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if(position!=RecyclerView.NO_POSITION) {
                        Movies movie = moviesArrayList.get(position);
                        Intent intent = new Intent(context, MovieDetailedActivity.class);
                        intent.putExtra("movie_model",movie );
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
