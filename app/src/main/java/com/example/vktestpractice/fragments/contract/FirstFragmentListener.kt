package com.example.vktestpractice.fragments.contract

import com.example.vktestpractice.model.GifData

// Create a listener in order to realize the transition to the second fragment
interface FirstFragmentListener {
    fun onGifClick(gifData: GifData)
}