package com.example.cocktail_mvvm.data.source.remote.api

import com.example.cocktail_mvvm.data.model.CocktailResponse
import com.example.cocktail_mvvm.utils.Constant
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("popular.php")
    fun getCocktail(
        @Query("rapidapi-key") apiKey: String = Constant.API_KEY,
    ): Call<CocktailResponse>
}
