package com.silvanav.cartelerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                if (adapterView != null) {
                    registerObserver(adapterView.getItemAtPosition(position).toString())
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                registerObserver("Ascendente")
            }
        }

        return binding.root
    }

    private fun initView() {
        adapter = MovieAdapter()
        binding.rvMovieList.adapter = adapter
        binding.rvMovieList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)
    }

    private fun registerObserver(string: String){
        viewModel.movieList().observe(viewLifecycleOwner) {
            it?.let {
                adapter.update(it, string)
            }
        }
    }


}