package com.silvanav.cartelerapp.model

import android.util.Log
import com.silvanav.cartelerapp.model.remote.RetrofitClient

class MovieRepository {

    private val TAG = "Repository"

     suspend fun getAllMovies() : MutableList<Movie>{
        val response = RetrofitClient.apiService.getMovies()
         val movieList = mutableListOf<Movie>()

        when (response.isSuccessful) {
            true -> {
                if (response.body() != null) {
                    movieList.addAll(response.body()!!.items.map {
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
         return movieList

    }

}