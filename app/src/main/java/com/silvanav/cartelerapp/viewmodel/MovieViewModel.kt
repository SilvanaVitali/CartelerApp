package com.silvanav.cartelerapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvanav.cartelerapp.model.Movie
import com.silvanav.cartelerapp.model.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel: ViewModel() {

    private val repository = MovieRepository()
    private var movieList = mutableListOf<Movie>()

    fun getAllMovies() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            movieList = repository.getAllMovies()
        }
    }

}