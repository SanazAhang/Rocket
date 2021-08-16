package com.example.racket.ui.rocketdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.racket.databinding.FragmentRocketDetailBinding
import com.example.racket.domain.model.Model

class RocketDetailFragment : Fragment() {

    private var binding: FragmentRocketDetailBinding? = null
    private lateinit var rocket: Model.Rocket
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            val args = RocketDetailFragmentArgs.fromBundle(bundle)
            rocket = args.rocket
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRocketDetailBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.rocket = rocket
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}