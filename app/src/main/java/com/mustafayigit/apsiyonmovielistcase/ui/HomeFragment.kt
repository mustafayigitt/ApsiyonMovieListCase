package com.mustafayigit.apsiyonmovielistcase.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mustafayigit.apsiyonmovielistcase.adapter.MovieAdapter
import com.mustafayigit.apsiyonmovielistcase.databinding.FragmentHomeBinding
import com.mustafayigit.apsiyonmovielistcase.ui.base.BaseFragment
import com.mustafayigit.apsiyonmovielistcase.util.*
import com.mustafayigit.apsiyonmovielistcase.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMovieRecycler()
        initObserver()

    }

    private fun initObserver() {
        homeViewModel.movies.observe(viewLifecycleOwner) {
            when (it) {
                is ResponseWrapper.Loading -> {
                    "Loading".safeLog()
                }
                is ResponseWrapper.Error -> {
                    "Error: ${it.errorType}".safeLog()

                }
                is ResponseWrapper.Success -> {
                    "Success: ${it.data}".safeLog()
                    (mBinding.recyclerMovies.adapter as MovieAdapter).submitList(it.data)

                }
            }
        }
    }

    private fun initMovieRecycler() {
        with(mBinding) {
            recyclerMovies.adapter = MovieAdapter { movie ->
                movie.toString() printToast requireContext()
            }
        }
    }
}