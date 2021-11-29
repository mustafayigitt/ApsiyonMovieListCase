package com.mustafayigit.apsiyonmovielistcase.data.model

data class MovieModel(
    val id: String,
    val title: String,
    val overview: String,
    val coverImagePath: String,
    val releaseDate: String,
    val genres: List<Int>,
    val popularity: Double,
    val voteAverage: Double,
    val voteCount: Int,
)
