package com.example.vktestpractice.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.vktestpractice.databinding.FragmentSecondBinding
import com.example.vktestpractice.model.GifData

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)

        showDetails()

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding.toolBar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun showDetails() {
        val gifData = requireArguments().getSerializable(GIF_DATA_VALUE) as GifData

        Glide.with(this@SecondFragment).load(gifData.images.original.url).into(binding.imView)
        binding.tvTitle.text = "title: ${gifData.title}"
        binding.tvId.text = "ID: ${gifData.id}"
        binding.tvImportDateTime.text = "Import DateTime: ${gifData.importDatetime}"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (parentFragmentManager.backStackEntryCount > 0) {
            parentFragmentManager.popBackStack()
        }
        return true
    }


    companion object {
        @JvmStatic
        private val GIF_DATA_VALUE = "GIFS_DATA_VALUE"

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(gifData: GifData) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(GIF_DATA_VALUE, gifData)
                }
            }
    }
}