package com.dokari4.submission1_pokeapi.core.data.remote.network

import com.dokari4.submission1_pokeapi.core.data.remote.response.ListMovieResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    fun getMovieList(
        @Query("api_key") apiKey: String = "75357c98d35a5dd7a0012d9d18d43337"
    ): Flowable<ListMovieResponse>

}