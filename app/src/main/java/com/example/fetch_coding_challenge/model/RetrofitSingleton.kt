package com.example.fetch_coding_challenge.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {
    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val getService: FetchApi by lazy { retrofit().create(FetchApi::class.java) }
}