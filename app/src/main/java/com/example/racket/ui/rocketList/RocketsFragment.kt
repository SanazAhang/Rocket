package com.example.racket.ui.rocketList

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.racket.databinding.FragmentRocketsBinding
import com.example.racket.domain.model.Model
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketsFragment : Fragment(), View.OnClickListener {

    private var binding: FragmentRocketsBinding? = null

    private val viewModel: RocketViewModel by viewModels()
    private val rocketAdapter = RocketAdapter()
    private lateinit var fromDateSetListener: DatePickerDialog.OnDateSetListener
    private lateinit var toDateSetListener: DatePickerDialog.OnDateSetListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.progressbar.visibility = View.GONE

        binding!!.recyclerViewRocket.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = rocketAdapter

        }

        rocketAdapter.setOnItemClickListener(object : RocketAdapter.ClickListener {
            override fun onClick(movie: Model.Rocket) {
                navigateToRocketDetail(movie)
            }

        })
        observer()
    }


    private fun observer() {

        viewModel.rocket.observe(viewLifecycleOwner,::onGetRocket)

        viewModel.error.observe(viewLifecycleOwner,::onError)

        viewModel.failure.observe(viewLifecycleOwner,::onFailure)

        viewModel.loading.observe(viewLifecycleOwner,::onLoading)

    }

    private fun onGetRocket(event: ConsumableValue<List<Model.Rocket>>) {
        event.consume {
            rocketAdapter.submitList(it)
            val layoutManager = binding?.recyclerViewRocket?.layoutManager
            layoutManager?.smoothScrollToPosition(binding?.recyclerViewRocket, null, 0)

        }
    }

    private fun onLoading(event: ConsumableValue<Boolean>) {
        event.consume {
            if (it) {
                binding!!.progressbar.visibility = View.VISIBLE
            } else {
                binding!!.progressbar.visibility = View.GONE
            }
        }
    }

    private fun onError(event: ConsumableValue<Throwable>) {
        event.consume {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

        }
    }

    private fun onFailure(event: ConsumableValue<String>) {

        event.consume {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

    }

    private fun navigateToRocketDetail(rocket: Model.Rocket) {
        val action =
            RocketsFragmentDirections.actionRocketsFragmentToRocketDetailFragment(rocket)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRocketsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onClick(v: View?) {

    }

}