package com.rgonzalez.cattracker.ui.list.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.rgonzalez.cattracker.data.model.CatModel
import com.rgonzalez.cattracker.databinding.CatItemBinding

class CatRecyclerViewHolder(private val binding: CatItemBinding, private val context: Context):RecyclerView.ViewHolder(binding.root) {

    fun bind(cat: CatModel, clickListener: (CatModel) -> Unit) {
        binding.catNameText.text = cat.name
        val resId = context.resources.getIdentifier("cat_${cat.color}", "drawable", context.packageName)
        binding.catImg.setImageResource(resId)
        binding.catColorText.text = cat.color.uppercase()
        binding.cardCatItem.setOnClickListener{
            clickListener(cat)
        }
    }
}