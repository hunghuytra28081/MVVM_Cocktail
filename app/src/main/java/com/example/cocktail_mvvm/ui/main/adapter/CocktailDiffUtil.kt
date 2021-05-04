package com.example.cocktail_mvvm.ui.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cocktail_mvvm.data.model.Cocktail

class CocktailDiffUtil : DiffUtil.ItemCallback<Cocktail>() {

    override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
        return oldItem == newItem
    }
}
