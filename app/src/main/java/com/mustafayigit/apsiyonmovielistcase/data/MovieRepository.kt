package com.mustafayigit.apsiyonmovielistcase.data

import com.mustafayigit.apsiyonmovielistcase.data.model.MovieModel
import com.mustafayigit.apsiyonmovielistcase.data.remote.service.MovieService
import com.mustafayigit.apsiyonmovielistcase.util.ErrorType
import com.mustafayigit.apsiyonmovielistcase.util.ResponseWrapper
import com.mustafayigit.apsiyonmovielistcase.util.safeCatch
import com.mustafayigit.apsiyonmovielistcase.util.safeLog
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val remote: MovieService,
) {

    private val pageData = mutableListOf<MovieModel>()

    suspend fun fetchMovies(page:Int): ResponseWrapper<List<MovieModel>> {
        return safeCatch {
            val result = remote.fetchMovies(page = page)
            when {
                result.isSuccessful -> {
                    pageData += result.body()?.results?.map {
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
                    "Paging: Total: ${pageData.count()}".safeLog()
                    ResponseWrapper.Success(pageData)
                }
                else -> {
                    result.errorBody().toString().safeLog()
                    null
                }
            }
        } ?: ResponseWrapper.Error(ErrorType.GENERIC_ERROR)
    }
}