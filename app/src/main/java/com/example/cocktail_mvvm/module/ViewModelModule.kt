package com.example.cocktail_mvvm.module

import com.example.cocktail_mvvm.ui.main.viewmodel.CocktailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CocktailViewModel(get()) }
}
