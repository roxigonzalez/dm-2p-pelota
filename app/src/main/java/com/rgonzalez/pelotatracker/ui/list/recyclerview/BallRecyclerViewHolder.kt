package com.rgonzalez.pelotatracker.ui.list.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.rgonzalez.pelotatracker.data.model.BallModel
import com.rgonzalez.pelotatracker.databinding.BallItemBinding

class BallRecyclerViewHolder(private val binding: BallItemBinding, private val context: Context):RecyclerView.ViewHolder(binding.root) {

    fun bind(ball: BallModel, clickListener: (BallModel) -> Unit) {
        binding.ballTypeText.text = ball.type
        binding.ballColorText.text = ball.color
        val resId = context.resources.getIdentifier("${ball.color}_ball", "drawable", context.packageName)
        binding.ballImg.setImageResource(resId)
        binding.cardBallItem.setOnClickListener{
            clickListener(ball)
        }
    }
}