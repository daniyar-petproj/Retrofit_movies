package com.example.retrofitmovies.movie

import com.google.gson.annotations.SerializedName
import java.lang.reflect.Constructor

data class MovieModel(

    @SerializedName("id")
    val id: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("release_date")
    val releaseDate: String?,

    @SerializedName("rt_score")
    val rtScore: String?,

    ) {
    constructor(title: String) : this(null, title, null, null, null)
}

