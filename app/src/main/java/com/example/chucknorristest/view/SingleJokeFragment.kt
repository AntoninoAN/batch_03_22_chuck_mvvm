package com.example.chucknorristest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorristest.databinding.SingleJokeFragmentLayoutBinding
import com.example.chucknorristest.model.JokeResponse
import com.example.chucknorristest.viewmodel.ChuckNorrisViewModel

class SingleJokeFragment: Fragment() {

    private lateinit var binding: SingleJokeFragmentLayoutBinding
    private val viewModel: ChuckNorrisViewModel by lazy {
        // When your viewModel is without a constructor
        ViewModelProvider(this)[ChuckNorrisViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        if (!::binding.isInitialized)
            binding = SingleJokeFragmentLayoutBinding.inflate(
                inflater,
                container,
                false
            )

        // presenter.getData()


        viewModel.singleJoke.observe(viewLifecycleOwner){
            // invoke after changes are "push" to the current Observer.
            updateUI(it)
        }
        viewModel.getSingleJoke()

        return binding.root
    }

    private fun updateUI(dataItem: JokeResponse) {
        binding.tvSingleJoke.text = dataItem.value.joke
    }

    override fun onResume() {
        super.onResume()
        viewModel.getSingleJoke()
    }
}






