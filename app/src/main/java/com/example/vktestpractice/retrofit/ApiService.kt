package com.example.vktestpractice.retrofit

import android.database.Observable
import com.example.vktestpractice.model.ApiResponseData
import retrofit2.http.GET

interface ApiService {
    @GET("v1/gifs/search?api_key=vcgtlk3XyPw26fWeHjrVE3R9IjjKEc37&q=get&limit=25&offset=0&rating=g&lang=en")
    fun getGifs(): Observable<ApiResponseData>
}