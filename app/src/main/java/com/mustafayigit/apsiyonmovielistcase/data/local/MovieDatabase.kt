package com.mustafayigit.apsiyonmovielistcase.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mustafayigit.apsiyonmovielistcase.data.local.dao.MovieDao
import com.mustafayigit.apsiyonmovielistcase.data.model.MovieModel


@Database(
    entities = [
        MovieModel::class,
    ],
    version = 1
)
@TypeConverters(DBConverter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}

class DBConverter {
    @TypeConverter
    fun listToString(value: List<Int>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun stringToList(value: String): List<Int> {
        val gson = Gson()
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.fromJson(value, type)
    }
}