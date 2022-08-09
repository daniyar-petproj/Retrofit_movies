package com.example.retrofitmovies.movie.retrofit

import com.example.retrofitmovies.movie.MovieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MoviesStorage {
    fun getAllMovies(result: AllMoviesResult) {
        RetrofitBuilder.getClient().getAllFilms()
            .enqueue(object : Callback<MutableList<MovieModel>> {
                override fun onResponse(
                    call: Call<MutableList<MovieModel>>,
                    response: Response<MutableList<MovieModel>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        result.onSuccess(response.body())
                    } else {
                        result.onFailure(response.code().toString())
                    }
                }

                override fun onFailure(call: Call<MutableList<MovieModel>>, t: Throwable) {
                    result.onFailure(t.localizedMessage)
                }
            })
    }

    fun getMovieById(id: String, result: MovieByIdResult) {
        RetrofitBuilder.getClient().getFilmById(id)
            .enqueue(object : Callback<MovieModel> {
                override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                    if (response.isSuccessful && response.body() != null) {
                        result.onSuccess(response.body())
                    } else {
                        result.onFailure(response.code().toString())
                    }
                }

                override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                    result.onFailure(t.localizedMessage)
                }

            })
    }

    interface MovieByIdResult {
        fun onSuccess(films: MovieModel?)
        fun onFailure(errMsg: String?)
    }

    interface AllMoviesResult {
        fun onSuccess(films: List<MovieModel>?)
        fun onFailure(errMsg: String?)
    }
}
