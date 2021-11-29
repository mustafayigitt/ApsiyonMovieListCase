package com.mustafayigit.apsiyonmovielistcase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafayigit.apsiyonmovielistcase.data.MovieRepository
import com.mustafayigit.apsiyonmovielistcase.data.model.MovieModel
import com.mustafayigit.apsiyonmovielistcase.util.ResponseWrapper
import com.mustafayigit.apsiyonmovielistcase.util.safeLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val STARTING_PAGE = 1

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {

    private var currentPage = STARTING_PAGE

    private val _movies: MutableLiveData<ResponseWrapper<List<MovieModel>>> = MutableLiveData()
    val movies: LiveData<ResponseWrapper<List<MovieModel>>> get() = _movies

    init {
        getMovies()
    }

    fun incrementCurrentPage() {
        currentPage++
    }

    fun getMovies(page: Int = currentPage) {
        viewModelScope.launch {
            if (currentPage >= 6) return@launch
            "Paging: CurrentPage: $currentPage".safeLog()
            _movies.postValue(ResponseWrapper.Loading)
            val movies = movieRepository.fetchMovies(page)
            _movies.postValue(movies)
        }
    }

}