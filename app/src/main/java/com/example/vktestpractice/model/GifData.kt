package com.example.vktestpractice.model

import com.google.gson.annotations.SerializedName

data class GifData(

    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("import_datetime")
    val importDatetime: String,

    @SerializedName("images")
    val images: Images

) : java.io.Serializable
