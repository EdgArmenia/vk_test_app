package com.example.vktestpractice.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.vktestpractice.model.GifData
import com.example.vktestpractice.retrofit.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MyViewModel(app: Application) : AndroidViewModel(app) {
    val gifsList: MutableLiveData<List<GifData>> = MutableLiveData<List<GifData>>()
    private val compositeDisposable = CompositeDisposable()

    fun getGifs(gifsApi: ApiService, query: String) {
        compositeDisposable.add(gifsApi.getGifs(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                gifsList.postValue(it.data)
            })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}