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
    // Create liveData of list of our gifs
    val gifsList: MutableLiveData<List<GifData>> = MutableLiveData<List<GifData>>()

    // Implement compositeDisposable
    private val compositeDisposable = CompositeDisposable()


    /** Implement method, where execute our http-request to get and put data to liveData
     *
     *  Subscribe to a new thread and execute our operation asynchrony
     *  Then add observer (main thread), subscribe on observable source (ApiResponseData)
     *  And post value to liveData
     * */
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