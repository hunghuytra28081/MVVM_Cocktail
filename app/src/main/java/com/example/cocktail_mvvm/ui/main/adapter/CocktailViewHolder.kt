package com.example.cocktail_mvvm.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktail_mvvm.R
import com.example.cocktail_mvvm.data.model.Cocktail
import com.example.cocktail_mvvm.databinding.ItemLayoutCocktailBinding
import com.example.cocktail_mvvm.ui.main.viewmodel.CocktailItemViewModel

class CocktailViewHolder(
    private val binding: ItemLayoutCocktailBinding,
    private var itemViewModel: CocktailItemViewModel = CocktailItemViewModel()
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.viewModel = itemViewModel
    }

    fun onBind(cocktail: Cocktail) {
        itemViewModel.setData(cocktail)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): CocktailViewHolder {
            val binding = DataBindingUtil.inflate<ItemLayoutCocktailBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_layout_cocktail, parent,
                false
            )
            return CocktailViewHolder(binding)
        }
    }
}
