package com.silvanav.cartelerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.silvanav.cartelerapp.databinding.FragmentMovieDetailBinding
import com.silvanav.cartelerapp.model.Movie
import com.squareup.picasso.Picasso

class MovieDetailFragment : Fragment() {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var movie: Movie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMovieDetailBinding.inflate(inflater,container,false)
        movie = MovieDetailFragmentArgs.fromBundle(requireArguments()).movie

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvTitleDetail.text = movie.title
            tvStarsDetail.text = movie.stars
            tvPlotDetail.text = movie.plot
            tvReleaseStateDetail.text = movie.releaseState
            Picasso.get().load(movie.image).into(ivMovieDetail)
        }
    }


}