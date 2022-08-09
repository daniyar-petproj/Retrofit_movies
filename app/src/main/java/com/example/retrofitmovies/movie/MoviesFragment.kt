package com.example.retrofitmovies.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitmovies.R
import com.example.retrofitmovies.databinding.FragmentMoviesBinding
import com.example.retrofitmovies.movie.retrofit.MoviesStorage

class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MovieAdapter
    private lateinit var movies: ArrayList<MovieModel>
    private lateinit var movieDetailFragment: MovieDetailFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)

        listenData()
        initViews()

        return binding.root
    }

    private fun initViews() {
        binding.rvMovies.layoutManager = LinearLayoutManager(context)
        movies = ArrayList<MovieModel>()

        movies.add(MovieModel("123213"))
        adapter = MovieAdapter(movies, this::onItemClickListener)

        binding.rvMovies.adapter = adapter
    }

    fun onItemClickListener(model: MovieModel) {
        if (model != null) {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if (transaction != null) {
                movieDetailFragment = MovieDetailFragment().apply {
                    arguments = Bundle().apply {
                        putString("movieFragment", model.id)
                    }
                }

                transaction.replace(R.id.main_container,movieDetailFragment )
                transaction.commit()

                Toast.makeText(requireContext(), "Yes yes yes", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun listenData() {
        MoviesStorage.getAllMovies(object : MoviesStorage.AllMoviesResult {
            override fun onSuccess(films: List<MovieModel>?) {
                if (films != null) {
                    adapter.setList(films)
                }
            }

            override fun onFailure(errMsg: String?) {
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
            }
        })
    }
}