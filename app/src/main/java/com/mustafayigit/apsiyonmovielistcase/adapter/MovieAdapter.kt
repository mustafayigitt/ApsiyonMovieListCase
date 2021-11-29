package com.mustafayigit.apsiyonmovielistcase.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mustafayigit.apsiyonmovielistcase.BuildConfig
import com.mustafayigit.apsiyonmovielistcase.data.model.MovieModel
import com.mustafayigit.apsiyonmovielistcase.databinding.AdapterItemMovieBinding
import com.mustafayigit.apsiyonmovielistcase.util.setImageWithGlide

class DiffCallback : DiffUtil.ItemCallback<MovieModel>() {
    override fun areItemsTheSame(
        oldItem: MovieModel,
        newItem: MovieModel
    ) = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: MovieModel,
        newItem: MovieModel
    ) =
        oldItem.id == newItem.id
}

class MovieAdapter(
    private inline val itemClickEvent: (MovieModel) -> Unit,
) : ListAdapter<MovieModel, MovieAdapter.MovieViewHolder>(DiffCallback()) {
    inner class MovieViewHolder(
        private val binding: AdapterItemMovieBinding,
        private inline val itemClickEvent: (MovieModel) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                itemClickEvent.invoke(currentList[adapterPosition])
            }
        }

        fun bind(movie: MovieModel) {
            with(binding) {
                txtMovieTitle.text = movie.title
                txtMovieReleaseDate.text = movie.releaseDate
                "${movie.voteAverage} / 10".also { txtMovieVoteAverage.text = it }

                val voteColor = getColorByVote(movie.voteAverage)
                txtMovieVoteAverage.setTextColor(voteColor)
                txtMovieVoteAverage.compoundDrawables.filterNotNull().firstOrNull()?.setTint(voteColor)

                imgMovieCoverImage.setImageWithGlide(
                    BuildConfig.STATIC_URL + movie.coverImagePath
                )
            }
        }

        private fun getColorByVote(voteAverage: Double): Int{
            return when {
                voteAverage < 7.0 -> Color.parseColor("#d0021b")
                voteAverage in 7.0..9.0 -> Color.parseColor("#f1a817")
                voteAverage > 9.0 -> Color.parseColor("#4caf50")
                else -> {
                    throw Exception("invalid vote average!!")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            binding = AdapterItemMovieBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            itemClickEvent = itemClickEvent
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}