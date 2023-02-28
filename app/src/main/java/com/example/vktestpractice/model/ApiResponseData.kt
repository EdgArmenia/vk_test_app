package com.example.vktestpractice.model

import com.google.gson.annotations.SerializedName

data class ApiResponseData(
    @SerializedName("data")
    val data: List<GifData>
)