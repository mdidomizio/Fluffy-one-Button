package com.example.fluffyonebutton

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    const val BASE_URL = "https://api.thecatapi.com/v1/images/search?format=json"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: RandomPicAPI = retrofit.create(RandomPicAPI::class.java)
}