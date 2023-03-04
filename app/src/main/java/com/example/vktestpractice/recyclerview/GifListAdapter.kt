package com.example.vktestpractice.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vktestpractice.R
import com.example.vktestpractice.databinding.GifItemBinding
import com.example.vktestpractice.fragments.FirstFragmentListener
import com.example.vktestpractice.model.GifData

class GifListAdapter(
    private val gifs: List<GifData>,
    private val context: Context,
    private val firstFragmentListener: FirstFragmentListener
) :
    RecyclerView.Adapter<GifListAdapter.GifHolder>() {

    class GifHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = GifItemBinding.bind(itemView)

        fun bind(itemGif: GifData, context: Context, firstFragmentListener: FirstFragmentListener) {
            Glide.with(context).load(itemGif.images.original.url).into(binding.imageView)
            binding.textView.text = itemGif.title

            binding.cardView.setOnClickListener {
                firstFragmentListener.onGifClick(itemGif)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gif_item, parent, false)

        return GifHolder(view)
    }

    override fun getItemCount(): Int = gifs.size

    override fun onBindViewHolder(holder: GifHolder, position: Int) {
        holder.bind(gifs[position], context, firstFragmentListener)
    }
}