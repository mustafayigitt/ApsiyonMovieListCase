package com.mustafayigit.apsiyonmovielistcase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.mustafayigit.apsiyonmovielistcase.data.model.MovieModel
import com.mustafayigit.apsiyonmovielistcase.databinding.AdapterItemMovieBinding
import com.mustafayigit.apsiyonmovielistcase.util.dpToPx
import com.mustafayigit.apsiyonmovielistcase.util.setImageWithGlide
import kotlin.math.roundToInt

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
                txtMovieDate.text = movie.date
                txtMovieRating.text = movie.rating.toString()

                imgMovieCover.setImageWithGlide(movie.coverImageUrl,RoundedCorners(10.dpToPx().roundToInt()))
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