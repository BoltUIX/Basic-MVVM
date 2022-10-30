package com.boltuix.mvvm.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.boltuix.mvvm.databinding.FragmentFirstBinding
import com.boltuix.mvvm.viewmodel.FirstFragmentViewModel
import com.squareup.picasso.Picasso


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val viewModel : FirstFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnRefresh.setOnClickListener {
            viewModel.fetchNewImageUrl()
        }

        viewModel.imageUrlLiveData.observe(viewLifecycleOwner) { imageUrl ->
            Picasso.get().load(imageUrl).into(binding.imageView)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}