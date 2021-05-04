package com.example.cocktail_mvvm.data.source.remote

import retrofit2.Retrofit

class RetrofitClient(private var retrofit: Retrofit) {

    fun <T> createService(interfaceService: Class<T>): T {
        return retrofit.create(interfaceService)
    }
}
