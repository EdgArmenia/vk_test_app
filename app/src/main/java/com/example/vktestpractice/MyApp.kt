package com.example.vktestpractice

import android.app.Application
import com.example.vktestpractice.retrofit.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MyApp : Application() {
    private val BASE_URL: String = "https://api.giphy.com/"
    lateinit var gifsApi: ApiService

    override fun onCreate() {
        super.onCreate()

        configureRetrofit()
    }

    // Implement retrofit
    private fun configureRetrofit() {
        // create httpLoggingInterceptor to see in logcat all information about requests
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        gifsApi = retrofit.create(ApiService::class.java)
    }
}