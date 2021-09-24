package com.example.cocktail_mvvm.ui.main.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.cocktail_mvvm.BR
import com.example.cocktail_mvvm.data.model.Cocktail

class CocktailItemViewModel : BaseObservable() {

    @Bindable
    var cocktail: Cocktail? = null

    fun setData(cocktail: Cocktail?) {
        cocktail?.let {
            this.cocktail = it
            notifyPropertyChanged(BR.cocktail)
        }
    }
}
