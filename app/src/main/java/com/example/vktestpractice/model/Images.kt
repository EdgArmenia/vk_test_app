package com.example.vktestpractice.model

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("original")
    val original: Original
) : java.io.Serializable
