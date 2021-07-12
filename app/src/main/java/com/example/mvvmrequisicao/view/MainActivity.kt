package com.example.mvvmrequisicao.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmrequisicao.R
import com.example.mvvmrequisicao.model.models.MovieItem
import com.example.mvvmrequisicao.viewmodel.MoviePopularViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = mutableListOf<MovieItem>()
    private val adapter = MovieAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MoviePopularViewModel::class.java)
        recyclerViewXml.adapter = adapter
        recyclerViewXml.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        viewModel.getPopularMovies()

        viewModel.movieResult.observe(this, Observer {
            adapter.updateList(it.results)
        })
    }
}