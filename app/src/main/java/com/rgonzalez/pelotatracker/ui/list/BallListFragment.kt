package com.rgonzalez.pelotatracker.ui.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rgonzalez.pelotatracker.R
import com.rgonzalez.pelotatracker.data.balls
import com.rgonzalez.pelotatracker.data.model.BallModel
import com.rgonzalez.pelotatracker.databinding.FragmentBallListBinding
import com.rgonzalez.pelotatracker.ui.list.recyclerview.BallRecyclerViewAdapter

class BallListFragment : Fragment() {

    //After create the view model, initialize it (and of course created the model and the repository)
    private val ballsViewModel: BallsViewModel by activityViewModels {
        BallsViewModel.Factory
    }

    private lateinit var binding: FragmentBallListBinding
    private lateinit var btnNewBall: FloatingActionButton
    private lateinit var recyclerViewAdapter: BallRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBallListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)
        btnNewBall = view.findViewById(R.id.add_ball_button)
        createNewCatListener()
    }

    private fun createNewCatListener(){
        btnNewBall.setOnClickListener{
            findNavController().navigate(R.id.action_ballListFragment_to_formBallFragment)
        }
    }

    private fun showSelectedItem(ball: BallModel) {
        ballsViewModel.setBallModel(ball)
        findNavController().navigate(R.id.action_ballListFragment_to_ballFragment)
    }
    private fun displayBalls() {
        recyclerViewAdapter.setData(ballsViewModel.getBalls())
        recyclerViewAdapter.notifyDataSetChanged()
    }
    private fun setRecyclerView(view: View) {
        binding.recyclerViewBall.layoutManager = LinearLayoutManager(view.context)
        recyclerViewAdapter = BallRecyclerViewAdapter{ selectedBall ->
            showSelectedItem(selectedBall)
        }
        binding.recyclerViewBall.adapter = recyclerViewAdapter
        displayBalls()
    }
}