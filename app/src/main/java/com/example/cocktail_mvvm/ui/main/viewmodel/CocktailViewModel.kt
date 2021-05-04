package com.example.cocktail_mvvm.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktail_mvvm.data.model.Cocktail
import com.example.cocktail_mvvm.data.model.CocktailResponse
import com.example.cocktail_mvvm.data.source.repositories.CocktailRepository
import com.example.cocktail_mvvm.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CocktailViewModel(private val cocktailRepository: CocktailRepository) : ViewModel() {

    private val _cocktails = MutableLiveData<Resource<MutableList<Cocktail>>>()
    val cocktails: LiveData<Resource<MutableList<Cocktail>>>
        get() = _cocktails

    init {
        fetchDataCocktail()
    }

    private fun fetchDataCocktail() {
        viewModelScope.launch {
            cocktailRepository.getCocktail().enqueue(object : Callback<CocktailResponse> {
                override fun onResponse(
                    call: Call<CocktailResponse>,
                    response: Response<CocktailResponse>
                ) {
                    _cocktails.postValue(Resource.success(response.body()?.resultApi!!))
                }

                override fun onFailure(call: Call<CocktailResponse>, t: Throwable) {
                    _cocktails.postValue(Resource.error(null, t.localizedMessage))
                }
            })
        }
    }
}
