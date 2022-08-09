package com.example.retrofitmovies.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.retrofitmovies.R
import com.example.retrofitmovies.databinding.FragmentMovieDetailBinding
import com.example.retrofitmovies.movie.retrofit.MoviesStorage


class MovieDetailFragment : Fragment() {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieModel: MovieModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)

        var answer = arguments?.getString("movieFragment")

        if (answer != null) {
            listenData(answer)
        } else {
            Toast.makeText(requireContext(), "Bitch", Toast.LENGTH_SHORT).show()
        }

        return binding.root

    }

    private fun listenData(id: String) {
        MoviesStorage.getMovieById(id, object : MoviesStorage.MovieByIdResult {
            override fun onSuccess(films: MovieModel?) {
                if (films != null) {
                    binding.tvTitle.text = films.title
                    binding.tvDescription.text = "Description: ${films.description}"
                    binding.tvReleaseDate.text = "Release Date: ${films.releaseDate}"
                    binding.tvRtScore.text = "Rt Score: ${films.rtScore}"
                }
            }

            override fun onFailure(errMsg: String?) {

            }
        })
    }
}