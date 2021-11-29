package com.mustafayigit.apsiyonmovielistcase.data

import com.mustafayigit.apsiyonmovielistcase.data.local.dao.MovieDao
import com.mustafayigit.apsiyonmovielistcase.data.model.MovieModel
import com.mustafayigit.apsiyonmovielistcase.data.remote.service.MovieService
import com.mustafayigit.apsiyonmovielistcase.util.ErrorType
import com.mustafayigit.apsiyonmovielistcase.util.ResponseWrapper
import com.mustafayigit.apsiyonmovielistcase.util.safeCatch
import com.mustafayigit.apsiyonmovielistcase.util.safeLog
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val remote: MovieService,
    private val local: MovieDao,
) {

    private val pageData = mutableListOf<MovieModel>()

    suspend fun fetchMovies(page: Int): ResponseWrapper<List<MovieModel>> {
        val result = safeCatch {
            val result = remote.fetchMovies(page = page).body()?.results.orEmpty()
            pageData += result.map {
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
            }
            "Paging: Total: ${pageData.count()}".safeLog()
            local.addMovies(pageData)
            pageData
        }

        return result
            .takeIf { it is ResponseWrapper.Success } ?: kotlin.run {
            if ((result is ResponseWrapper.Error) and ((result as ResponseWrapper.Error).errorType == ErrorType.NETWORK_ERROR)) {
                "Movies from Local".safeLog()
                ResponseWrapper.Success(local.getAllMovies())
            } else result
        }
    }
}