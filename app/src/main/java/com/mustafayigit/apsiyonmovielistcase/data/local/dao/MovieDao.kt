package com.mustafayigit.apsiyonmovielistcase.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mustafayigit.apsiyonmovielistcase.data.model.MovieModel

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovies(movies: List<MovieModel>)

    @Query("select * from movies")
    suspend fun getAllMovies(): List<MovieModel>
}