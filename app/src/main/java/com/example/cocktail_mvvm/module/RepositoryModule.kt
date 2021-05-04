package com.example.cocktail_mvvm.module

import com.example.cocktail_mvvm.data.source.repositories.CocktailRepository
import com.example.cocktail_mvvm.data.source.repositories.CocktailRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<CocktailRepository> { CocktailRepositoryImpl(get()) }
}
