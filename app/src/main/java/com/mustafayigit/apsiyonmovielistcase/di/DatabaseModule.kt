package com.mustafayigit.apsiyonmovielistcase.di

import android.content.Context
import androidx.room.Room
import com.mustafayigit.apsiyonmovielistcase.data.local.MovieDatabase
import com.mustafayigit.apsiyonmovielistcase.data.local.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext appContext: Context,
    ): MovieDatabase {
       return Room.databaseBuilder(
            appContext,
            MovieDatabase::class.java,
            "db_apsiyon_movie"
        ).build()
    }

    @Provides
    fun provideMovieDao(appDatabase: MovieDatabase): MovieDao = appDatabase.movieDao()
}