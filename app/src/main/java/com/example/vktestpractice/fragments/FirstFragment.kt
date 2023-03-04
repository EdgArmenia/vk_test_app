package com.example.vktestpractice.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vktestpractice.MyApp
import com.example.vktestpractice.R
import com.example.vktestpractice.databinding.FragmentFirstBinding
import com.example.vktestpractice.model.GifData
import com.example.vktestpractice.recyclerview.GifListAdapter
import com.example.vktestpractice.viewmodels.MyViewModel

class FirstFragment : Fragment(), FirstFragmentListener {
    private val viewModel: MyViewModel by viewModels()
    private lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolBar)

        viewModel.gifsList.observe(viewLifecycleOwner) {
            showData(it)
        }

    }

    private fun showData(gifsList: List<GifData>) = with(binding) {
        rcView.layoutManager = LinearLayoutManager(requireContext())
        rcView.adapter = GifListAdapter(gifsList, requireContext(), this@FirstFragment)
    }

    override fun onGifClick(gifData: GifData) {
        val fragment = SecondFragment.newInstance(gifData)

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.first_fragment_menu, menu)

        val searchView = SearchView((context as AppCompatActivity).supportActionBar?.themedContext!!)

        menu.findItem(R.id.search_button).actionView = searchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                showTextIntro(query == null || query.isEmpty())

                viewModel.getGifs((activity?.application as MyApp).gifsApi, query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                showTextIntro(newText == null || newText.isEmpty())

                viewModel.getGifs((activity?.application as MyApp).gifsApi, newText!!)
                return true
            }

        })
    }

    private fun showTextIntro(textIsEmpty: Boolean) = with(binding){
        when (textIsEmpty) {
            true -> tViewInfo.visibility = View.VISIBLE
            false -> tViewInfo.visibility = View.GONE
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}