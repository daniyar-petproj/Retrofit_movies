package com.example.retrofitmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitmovies.movie.MoviesFragment


var moviesFragment: MoviesFragment? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment()
    }

    public fun replaceFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        moviesFragment?.let { transaction.replace(R.id.main_container, it) }
        transaction.commit()
    }
}