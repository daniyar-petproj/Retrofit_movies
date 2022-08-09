package com.example.retrofitmovies.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmovies.R


private lateinit var movies: List<MovieModel>
class MovieAdapter(private var movies: List<MovieModel>, private val listener: (MovieModel)->Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bind(movies.get(position), listener)
        holder.number.text = position.toString() + "."
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setList(movieModel: List<MovieModel>) {
        this.movies = movieModel
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.tv_title_item)
        val number: TextView = itemView.findViewById(R.id.tv_number_item)


        fun bind(get: MovieModel, listener: (MovieModel) -> Unit) {
            title.text = get.title
            itemView.setOnClickListener {
                listener(get)
            }
        }
    }
}
