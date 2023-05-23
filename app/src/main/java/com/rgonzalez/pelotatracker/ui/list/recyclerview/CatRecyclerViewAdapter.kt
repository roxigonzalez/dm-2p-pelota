package com.rgonzalez.cattracker.ui.list.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rgonzalez.cattracker.data.model.CatModel
import com.rgonzalez.cattracker.databinding.CatItemBinding

class CatRecyclerViewAdapter(
    private val clickListener: (CatModel) -> Unit
): RecyclerView.Adapter<CatRecyclerViewHolder>() {

    private val cats = ArrayList<CatModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatRecyclerViewHolder {
        val binding = CatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatRecyclerViewHolder(binding, parent.context)
    }

    override fun getItemCount(): Int {
       return cats.size
    }

    override fun onBindViewHolder(holder: CatRecyclerViewHolder, position: Int) {
        val cat = cats[position]
        holder.bind(cat, clickListener)
    }

    fun setData(catsList: List<CatModel>) {
        cats.clear()
        cats.addAll(catsList)
        notifyDataSetChanged() // TODO Forzar update visual ?
    }


}