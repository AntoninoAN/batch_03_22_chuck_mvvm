package com.example.chucknorristest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorristest.databinding.NamedJokeFragmentLayoutBinding
import com.example.chucknorristest.model.JokeResponse
import com.example.chucknorristest.viewmodel.ChuckNorrisViewModel

class NamedJokeFragment: Fragment() {
    private lateinit var binding: NamedJokeFragmentLayoutBinding
    private val viewModel: ChuckNorrisViewModel by lazy {
        ViewModelProvider(this)[ChuckNorrisViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = NamedJokeFragmentLayoutBinding
            .inflate(inflater, container, false)
        initViews()

        viewModel.singleJoke.observe(viewLifecycleOwner){dataSet->
            updateUI(dataSet)
        }
        return binding.root
    }

    private fun updateUI(dataSet: JokeResponse) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, SingleJokeFragment())
            .commit()
    }

    private fun initViews() {
        binding.btnGetJoke.setOnClickListener {
            if (binding.etInputName.text.isNotEmpty())
                viewModel.getNamedJoke(
                    binding.etInputName.text.toString().split(' ')[0],
                    binding.etInputName.text.toString().split(' ')[1]
                )
        }
    }
}


