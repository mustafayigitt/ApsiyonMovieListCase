package com.mustafayigit.apsiyonmovielistcase.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.mustafayigit.apsiyonmovielistcase.BuildConfig
import com.mustafayigit.apsiyonmovielistcase.databinding.FragmentMovieDetailBinding
import com.mustafayigit.apsiyonmovielistcase.ui.base.BaseFragment
import com.mustafayigit.apsiyonmovielistcase.util.setImageWithGlide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment
    : BaseFragment<FragmentMovieDetailBinding>(
    FragmentMovieDetailBinding::inflate
) {
    private val args:MovieDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(mBinding){
            txtMovieDetailTitle.text = args.movieModel.title
            txtMovieDetailOverview.text = args.movieModel.overview
            imgMovieDetailBackground.setImageWithGlide(
                BuildConfig.STATIC_URL + args.movieModel.coverImagePath
            )
        }
    }
}