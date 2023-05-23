package com.rgonzalez.pelotatracker.ui.form

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.rgonzalez.pelotatracker.databinding.FragmentFormBallBinding

class FormBallFragment : Fragment() {

    private val formBallViewModel: FormBallViewModel by activityViewModels {
        FormBallViewModel.Factory
    }
    private lateinit var binding: FragmentFormBallBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormBallBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun observeStatus() {
        formBallViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(FormBallViewModel.WRONG_DATA) -> {
                    Log.d("TAG", status)
                    formBallViewModel.clearStatus()
                }
                status.equals(FormBallViewModel.BALL_CREATED) -> {
                    Log.d("TAG", status)
                    formBallViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
    fun setViewModel() {
        binding.viewmodel = formBallViewModel
    }




}