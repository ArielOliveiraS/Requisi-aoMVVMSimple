package com.example.mvvmrequisicao.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmrequisicao.model.api.API_KEY
import com.example.mvvmrequisicao.model.api.RetrofitService
import com.example.mvvmrequisicao.model.models.MovieResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MoviePopularViewModel() : ViewModel() {

    val disposable = CompositeDisposable()
    val movieResult: MutableLiveData<MovieResponse> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()

    fun getPopularMovies() {
        disposable.add(
            RetrofitService.service.getPopularMovies(API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    movieResult.value = it
                }, { e ->
                    error.value = e.message
                })

        )
    }
}
