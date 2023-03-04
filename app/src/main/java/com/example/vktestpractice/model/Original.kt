package com.example.vktestpractice.model

import com.google.gson.annotations.SerializedName

data class Original(
    @SerializedName("url")
    val url: String
) : java.io.Serializable