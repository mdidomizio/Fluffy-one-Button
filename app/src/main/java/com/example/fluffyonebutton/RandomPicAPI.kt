package com.example.fluffyonebutton

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RandomPicAPI {
    @Headers()
    @GET("photo/random")
    fun getRandomPic(): Call<PhotoGalleryClass>
}