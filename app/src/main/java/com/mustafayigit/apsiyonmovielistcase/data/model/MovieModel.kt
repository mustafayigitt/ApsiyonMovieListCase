package com.mustafayigit.apsiyonmovielistcase.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieModel(
    @PrimaryKey
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
