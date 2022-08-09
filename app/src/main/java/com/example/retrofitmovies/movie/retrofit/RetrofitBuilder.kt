package com.example.retrofitmovies.movie.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val BASE_URL = "https://ghibliapi.herokuapp.com/"
    private var retrofit: MoviesAPI? = null

     fun getClient(): MoviesAPI {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesAPI::class.java)
        }
        return retrofit!!
    }
}