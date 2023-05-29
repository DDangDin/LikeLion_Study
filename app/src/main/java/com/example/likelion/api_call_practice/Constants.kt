package com.example.likelion.api_call_practice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {

    const val BASE_URL = "https://dog.ceo"

    val retrofitInstance = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val dogApi: DogApi by lazy { retrofitInstance.create(DogApi::class.java) }
}