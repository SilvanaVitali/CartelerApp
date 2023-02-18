package com.silvanav.cartelerapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.silvanav.cartelerapp.databinding.MovieItemBinding
import com.silvanav.cartelerapp.model.Movie
import com.squareup.picasso.Picasso

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val movieList = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context))
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    fun update(list: List<Movie>){
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){
            binding.tvTitle.text = movie.title
            binding.tvReleaseState.text = movie.releaseState
            Picasso.get().load(movie.image).into(binding.ivMovie)
        }
    }
}

