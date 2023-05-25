package com.example.new_app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    // https://internship-service.onrender.com/videos?page=2
    val BASE_URL = "https://internship-service.onrender.com/"

    fun getInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}