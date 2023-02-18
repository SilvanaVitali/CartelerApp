package com.silvanav.cartelerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvanav.cartelerapp.model.Movie
import com.silvanav.cartelerapp.model.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {

    private val repository = MovieRepository()
    private val movieList = MutableLiveData<List<Movie>>()

    fun movieList(): LiveData<List<Movie>> = movieList

    init {
        getAllMovies()
    }

    fun getAllMovies() = viewModelScope.launch {
            movieList.value = repository.getAllMovies()
        }

}