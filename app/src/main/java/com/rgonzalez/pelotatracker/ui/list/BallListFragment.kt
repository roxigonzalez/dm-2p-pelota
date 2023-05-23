package com.rgonzalez.cattracker.ui.list

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
import com.rgonzalez.cattracker.ui.list.recyclerview.CatRecyclerViewAdapter

class BallListFragment : Fragment() {

    //After create the view model, initialize it (and of course created the model and the repository)
    private val ballsViewModel: BallsViewModel by activityViewModels {
        BallsViewModel.Factory
    }

}