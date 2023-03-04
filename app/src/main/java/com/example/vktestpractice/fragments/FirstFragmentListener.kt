package com.example.vktestpractice.fragments

import com.example.vktestpractice.model.GifData

interface FirstFragmentListener {
    fun onGifClick(gifData: GifData)
}