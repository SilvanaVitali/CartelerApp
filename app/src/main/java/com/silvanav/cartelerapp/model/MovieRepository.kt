package com.silvanav.cartelerapp.model

import android.util.Log
import com.silvanav.cartelerapp.model.local.MovieApplication
import com.silvanav.cartelerapp.model.remote.RetrofitClient

class MovieRepository {

    private val TAG = "Repository"
    private val movieDao = MovieApplication.movieDatabase!!.movieDao()
    val movieList = movieDao.getAllMovies()

     suspend fun getAllMovies(){
        val response = RetrofitClient.apiService.getMovies()

        when (response.isSuccessful) {
            true -> {
                if (response.body() != null) {
                    movieDao.insertAllMovies(response.body()!!.items.map {
                        it.copy(errorMessage = response.body()!!.errorMessage)
                    })
                    Log.d(TAG, "getAllMovies: ${response.body()}")
                } else {
                    Log.d(TAG, "getAllMovies: body is null")
                }
            }
            false -> {
                Log.d(TAG, "getAllMovies: error code ${response.code()}")
            }
        }
    }

}