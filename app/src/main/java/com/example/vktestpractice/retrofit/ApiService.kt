package com.example.vktestpractice.retrofit

import com.example.vktestpractice.model.ApiResponseData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/gifs/search?api_key=vcgtlk3XyPw26fWeHjrVE3R9IjjKEc37&limit=25&offset=0&rating=g&lang=en")
    fun getGifs(@Query("q") query: String): Observable<ApiResponseData>
}