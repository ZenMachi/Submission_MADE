package com.dokari4.submission1_pokeapi.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dokari4.submission1_pokeapi.MyApplication
import com.dokari4.submission1_pokeapi.R
import com.dokari4.submission1_pokeapi.R.drawable.baseline_favorite_filled_24
import com.dokari4.submission1_pokeapi.R.drawable.baseline_favorite_unfilled_24
import com.dokari4.submission1_pokeapi.core.ui.ViewModelFactory
import com.dokari4.submission1_pokeapi.databinding.ActivityDetailBinding
import com.dokari4.submission1_pokeapi.domain.model.Movie
import javax.inject.Inject


class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    companion object {
        const val EXTRA_DATA = "extra_data"
    }
    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)

//        val factory = ViewModelFactory.getInstance(this)
//        detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        showDetail(detailMovie)
    }

    private fun showDetail(detailMovie: Movie?) {
        detailMovie?.let {
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/original${detailMovie.posterPath}")
                .into(binding.imgMovie)

            binding.tvMovieName.text = detailMovie.title
            binding.tvMovieOverview.text = detailMovie.overview
            var statusFavorite = detailMovie.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fabFav.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fabFav.setImageDrawable(ContextCompat.getDrawable(this, baseline_favorite_filled_24)) }
        else {
            binding.fabFav.setImageDrawable(ContextCompat.getDrawable(this, baseline_favorite_unfilled_24)) }
    }
}