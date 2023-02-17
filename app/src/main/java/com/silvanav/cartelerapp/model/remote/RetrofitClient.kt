package com.silvanav.cartelerapp.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        val apiService: MovieApi by lazy {
            instance().create(MovieApi::class.java)
        }

        private const val BASE_URL = "https://my.api.mockaroo.com/"
        fun instance() = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}