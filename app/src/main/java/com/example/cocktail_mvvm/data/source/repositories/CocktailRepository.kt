package com.example.cocktail_mvvm.data.source.repositories

import com.example.cocktail_mvvm.data.model.CocktailResponse
import com.example.cocktail_mvvm.data.source.remote.api.ApiService
import retrofit2.Call

interface CocktailRepository {

    fun getCocktail(): Call<CocktailResponse>
}

class CocktailRepositoryImpl(private val apiService: ApiService) : CocktailRepository {

    override fun getCocktail() = apiService.getCocktail()
}
