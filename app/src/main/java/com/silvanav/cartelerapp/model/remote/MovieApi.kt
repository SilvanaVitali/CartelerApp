package com.silvanav.cartelerapp.model.remote

import com.silvanav.cartelerapp.model.MovieData
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {

    @GET("movies.json?key=cb03b960")
    suspend fun getMovies(): Response<MovieData>

}