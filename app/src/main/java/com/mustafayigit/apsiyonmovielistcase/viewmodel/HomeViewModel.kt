package com.mustafayigit.apsiyonmovielistcase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafayigit.apsiyonmovielistcase.data.MovieRepository
import com.mustafayigit.apsiyonmovielistcase.data.model.MovieModel
import com.mustafayigit.apsiyonmovielistcase.util.ResponseWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
): ViewModel(){

    private val _movies: MutableLiveData<ResponseWrapper<List<MovieModel>>> = MutableLiveData()
    val movies: LiveData<ResponseWrapper<List<MovieModel>>> get() = _movies


    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            val movies = movieRepository.fetchMovies()
            _movies.postValue(movies)
        }
    }

}