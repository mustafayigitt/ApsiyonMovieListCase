package com.mustafayigit.apsiyonmovielistcase.data.remote.service

import com.mustafayigit.apsiyonmovielistcase.BuildConfig
import com.mustafayigit.apsiyonmovielistcase.data.remote.response.ResponseMovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun fetchMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("language") lang: String = "en",
        @Query("page") page: Int = 1
    ): Response<ResponseMovieList>
}