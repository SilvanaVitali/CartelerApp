package com.silvanav.cartelerapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.silvanav.cartelerapp.databinding.MovieItemBinding
import com.silvanav.cartelerapp.model.Movie
import com.squareup.picasso.Picasso
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

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

    fun update(list: List<Movie>, string: String, test: Boolean = false){
        if (list.isNotEmpty()) {
            movieList.clear()
            orderBy(list, string)
            if (!test) {notifyDataSetChanged()}
        }
    }

    fun orderBy(list: List<Movie>,string: String) {
        if (string == "Ascendente") {
            movieList.addAll(list.sortedBy {stringToDate(it.releaseState)})
        } else {
            movieList.addAll(list.sortedByDescending {stringToDate(it.releaseState)})
        }
    }

    fun stringToDate(releaseState: String): LocalDate {
        val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.US)
        return LocalDate.parse(releaseState,formatter)
    }

    inner class MovieViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){
            binding.tvTitle.text = movie.title
            binding.tvReleaseState.text = movie.releaseState
            Picasso.get().load(movie.image).into(binding.ivMovie)

            this.itemView.setOnClickListener {
                val action = MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(movie)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}

