package com.example.chucknorristest.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    const val BASE_URL = "https://api.icndb.com/"
    const val END_POINT = "jokes/random"

    val chuckApi: ChuckApi by lazy {
        initRetrofit()
    }

    private fun initRetrofit(): ChuckApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChuckApi::class.java)
    }
}