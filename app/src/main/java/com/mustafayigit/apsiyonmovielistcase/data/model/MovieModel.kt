package com.mustafayigit.apsiyonmovielistcase.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "movies")
@Parcelize
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
): Parcelable
