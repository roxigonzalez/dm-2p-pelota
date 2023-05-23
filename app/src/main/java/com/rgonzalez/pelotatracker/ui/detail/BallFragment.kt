package com.rgonzalez.pelotatracker.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.rgonzalez.pelotatracker.databinding.FragmentBallBinding
import com.rgonzalez.pelotatracker.ui.list.BallsViewModel


class BallFragment : Fragment() {

    private lateinit var binding: FragmentBallBinding

    private val ballViewModel: BallViewModel by activityViewModels {
        BallViewModel.Factory
    }
    private val ballsViewModel: BallsViewModel by activityViewModels {
        BallsViewModel.Factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ballModelFromList = ballsViewModel.getBallModel()
        ballModelFromList.value?.let { ballViewModel.setBallModel(it) }
        binding.viewmodel = ballViewModel
        val context = view.context
        val resId = context.resources.getIdentifier("${ballViewModel.color.value}_ball", "drawable", context.packageName)
        binding.detailImgBall.setImageResource(resId)
        Log.d("TAG",  "${ballModelFromList.value.toString()}")
    }

}