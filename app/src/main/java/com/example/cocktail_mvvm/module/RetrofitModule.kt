package com.example.cocktail_mvvm.module

import com.example.cocktail_mvvm.data.source.remote.RetrofitClient
import com.example.cocktail_mvvm.utils.Constant
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    fun provideGson() = GsonBuilder().create()

    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .build()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(Constant.BASE_URL)
            .build()
    }

    fun provideClient(retrofit: Retrofit): RetrofitClient {
        return RetrofitClient(retrofit)
    }

    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get()) }
    single { provideClient(get()) }
}
