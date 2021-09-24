package com.example.cocktail_mvvm.data.model

import com.google.gson.annotations.SerializedName

data class Cocktail(
    @SerializedName("idDrink")
    val id: String?,
    @SerializedName("strDrink")
    var name: String?,
    @SerializedName("strInstructions")
    var instructions: String?,
    @SerializedName("strGlass")
    var glass: String?,
    @SerializedName("strDrinkThumb")
    var image: String?
)
