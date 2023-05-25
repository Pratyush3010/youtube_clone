package com.example.new_app

import retrofit2.Call
import retrofit2.http.GET

interface ServiceApi {

    @GET("videos?page=2")

    fun getposts() : Call<modal>
}