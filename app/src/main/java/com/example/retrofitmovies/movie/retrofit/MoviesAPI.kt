package com.example.retrofitmovies.movie.retrofit

import com.example.retrofitmovies.movie.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesAPI {
    @GET("films")
    fun getAllFilms(): Call<MutableList<MovieModel>>

    @GET("/films/{id}")
    fun getFilmById(@Path("id") id: String?): Call<MovieModel>
}