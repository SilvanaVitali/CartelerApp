package com.silvanav.cartelerapp.model

import android.util.Log
import com.silvanav.cartelerapp.model.remote.RetrofitClient

class MovieRepository {

    private val TAG = "Repository"

     suspend fun getAllMovies() {
        val response = RetrofitClient.apiService.getMovies()

        when (response.isSuccessful) {
            true -> {
                if (response.body() != null) {

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