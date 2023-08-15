package com.dokari4.submission1_pokeapi.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.dokari4.submission1_pokeapi.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getMovieList().toLiveData()
}