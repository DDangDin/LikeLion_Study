package com.example.likelion.api_call_practice

import retrofit2.http.GET

interface DogApi {

    @GET("/api/breeds/image/random")
    suspend fun getDogImage(): Dog
}