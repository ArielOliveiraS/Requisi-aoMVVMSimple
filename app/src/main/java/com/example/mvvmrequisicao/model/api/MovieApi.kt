package com.example.mvvmrequisicao.model.api

import com.example.mvvmrequisicao.model.models.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Single<MovieResponse>
}