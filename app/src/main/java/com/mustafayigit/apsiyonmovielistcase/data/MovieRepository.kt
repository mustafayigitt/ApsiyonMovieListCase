package com.mustafayigit.apsiyonmovielistcase.data

import com.mustafayigit.apsiyonmovielistcase.R
import com.mustafayigit.apsiyonmovielistcase.data.model.MovieModel
import com.mustafayigit.apsiyonmovielistcase.data.remote.service.MovieService
import com.mustafayigit.apsiyonmovielistcase.util.*
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val remote: MovieService,
) {

    suspend fun fetchMovies(): ResponseWrapper<List<MovieModel>> {
        return safeCatch {
            val result = remote.fetchMovies()
            when {
                result.isSuccessful -> {
                    val movies = result.body()?.results?.map {
                        MovieModel(
                            it.id,
                            it.title,
                            it.overview,
                            it.poster_path,
                            it.release_date,
                            it.genre_ids,
                            it.popularity,
                            it.vote_average,
                            it.vote_count
                        )
                    } ?: emptyList()
                    ResponseWrapper.Success(movies)
                }
                else -> {
                    result.errorBody().toString().safeLog()
                    null
                }
            }
        } ?: ResponseWrapper.Error(ErrorType.GENERIC_ERROR)
    }
}