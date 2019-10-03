package com.vinaykumar.myapplication.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.vinaykumar.myapplication.model.Movies;
import com.vinaykumar.myapplication.model.MoviesRepository;

import java.util.List;

public class MoviesViewModel extends AndroidViewModel {
    MoviesRepository moviesRepository ;

    public MoviesViewModel(@NonNull Application application) {
        super(application);
        moviesRepository = new MoviesRepository(application);
    }

   public LiveData<List<Movies> > getAllMovies(){
    return moviesRepository.getMovieData();
    }

}
