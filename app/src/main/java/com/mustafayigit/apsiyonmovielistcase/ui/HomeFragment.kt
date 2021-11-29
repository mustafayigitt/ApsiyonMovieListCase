package com.mustafayigit.apsiyonmovielistcase.ui

import android.os.Bundle
import android.view.View
import com.mustafayigit.apsiyonmovielistcase.adapter.MovieAdapter
import com.mustafayigit.apsiyonmovielistcase.data.model.MovieModel
import com.mustafayigit.apsiyonmovielistcase.databinding.FragmentHomeBinding
import com.mustafayigit.apsiyonmovielistcase.ui.base.BaseFragment
import com.mustafayigit.apsiyonmovielistcase.util.CustomItemDecoration
import com.mustafayigit.apsiyonmovielistcase.util.dpToPx
import com.mustafayigit.apsiyonmovielistcase.util.printToast
import kotlin.math.roundToInt

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(mBinding) {
            recyclerMovies.adapter = MovieAdapter { movie ->
                movie.toString() printToast requireContext()
            }.also {
                it.submitList(
                    List(10) {
                        MovieModel(
                            it.toString(),
                            "asdadada",
                            "https://assets.materialup.com/uploads/539a61f4-af79-4dae-9b03-30cb506f69e2/preview.png",
                            "ada",
                            7.3
                        )
                    }
                )
            }
            recyclerMovies.addItemDecoration(
                CustomItemDecoration(
                    spaceBottom = 20.dpToPx().roundToInt()
                )
            )
        }

    }
}