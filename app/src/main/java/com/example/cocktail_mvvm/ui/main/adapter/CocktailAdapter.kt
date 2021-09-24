package com.example.cocktail_mvvm.ui.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cocktail_mvvm.data.model.Cocktail

class CocktailAdapter : ListAdapter<Cocktail, CocktailViewHolder>(CocktailDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        return CocktailViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    fun setData(data: MutableList<Cocktail>?) {
        data?.let { submitList(it.toMutableList()) }
    }
}
