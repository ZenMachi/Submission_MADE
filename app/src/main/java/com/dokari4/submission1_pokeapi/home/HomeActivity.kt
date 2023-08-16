package com.dokari4.submission1_pokeapi.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dokari4.submission1_pokeapi.MyApplication
import com.dokari4.submission1_pokeapi.core.data.Resource
import com.dokari4.submission1_pokeapi.core.ui.MovieAdapter
import com.dokari4.submission1_pokeapi.core.ui.ViewModelFactory
import com.dokari4.submission1_pokeapi.databinding.ActivityHomeBinding
import com.dokari4.submission1_pokeapi.detail.DetailActivity
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = {selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

//        val factory = ViewModelFactory.getInstance(this)
//        homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

        homeViewModel.movie.observe(this) { movie ->
            if (movie != null) {
                when (movie) {
                    is Resource.Success -> {
                        movieAdapter.setData(movie.data)
                    }

                    else -> {}
                }
            }
        }

        with(binding.rvMovie) {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}