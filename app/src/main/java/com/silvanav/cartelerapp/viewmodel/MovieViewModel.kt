package com.silvanav.cartelerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvanav.cartelerapp.model.Movie
import com.silvanav.cartelerapp.model.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel: ViewModel() {

    private val repository = MovieRepository()

    fun movieList(): LiveData<List<Movie>> = repository.movieList

    init {
        getAllMovies()
    }

    private fun getAllMovies() = viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.getAllMovies()
            }
        }

}