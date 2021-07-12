package com.example.mvvmrequisicao.model.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "1efd8cd26867ff738891e74665d8c9b9"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500/"


class RetrofitService {
    companion object {
        val service: MovieApi

        init {
            val gson = GsonBuilder().setLenient().create()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            service = retrofit.create(MovieApi::class.java)
        }
    }
}
