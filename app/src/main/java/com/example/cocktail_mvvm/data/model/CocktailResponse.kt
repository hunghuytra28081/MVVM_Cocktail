package com.example.cocktail_mvvm.data.model

import com.google.gson.annotations.SerializedName

data class CocktailResponse(
    @SerializedName("drinks")
    val resultApi: MutableList<Cocktail>?
)
