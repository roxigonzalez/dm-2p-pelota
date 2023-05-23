package com.rgonzalez.pelotatracker.ui.list.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rgonzalez.pelotatracker.data.model.BallModel
import com.rgonzalez.pelotatracker.databinding.BallItemBinding

class BallRecyclerViewAdapter(
    private val clickListener: (BallModel) -> Unit
) : RecyclerView.Adapter<BallRecyclerViewHolder>() {

    private val balls = ArrayList<BallModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BallRecyclerViewHolder {
        val binding = BallItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BallRecyclerViewHolder(binding, parent.context)
    }

    override fun getItemCount(): Int {
        return balls.size
    }

    override fun onBindViewHolder(holder: BallRecyclerViewHolder, position: Int) {
        val ball = balls[position]
        holder.bind(ball, clickListener)
    }

    fun setData(ballsList: List<BallModel>) {
        balls.clear()
        balls.addAll(ballsList)
        notifyDataSetChanged() // Forzar update visual
    }


}