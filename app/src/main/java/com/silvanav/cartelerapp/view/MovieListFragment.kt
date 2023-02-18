package com.silvanav.cartelerapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.silvanav.cartelerapp.databinding.FragmentMovieListBinding
import com.silvanav.cartelerapp.viewmodel.MovieViewModel


class MovieListFragment : Fragment() {

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MovieViewModel>()
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMovieListBinding.inflate(inflater,container,false)

        initView()
        registerObserver()

        return binding.root
    }

    private fun initView() {
        adapter = MovieAdapter()
        binding.rvMovieList.adapter = adapter
        binding.rvMovieList.layoutManager = LinearLayoutManager(context,1,false)
    }

    private fun registerObserver(){
        viewModel.movieList().observe(viewLifecycleOwner) {
            Log.d("SIL", "onCreateView: registerObserver: ${it[0]}")
            it?.let {
                adapter.update(it)
            }
        }
    }


}