package com.example.cocktail_mvvm.module

import com.example.cocktail_mvvm.data.source.remote.RetrofitClient
import com.example.cocktail_mvvm.data.source.remote.api.ApiService
import org.koin.dsl.module

val apiModule = module {

    fun provideUseApi(retrofit: RetrofitClient) = retrofit.createService(ApiService::class.java)
    single { provideUseApi(get()) }
}
