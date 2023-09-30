package com.example.echocities.endpoint

import com.example.echocities.data.Map
import retrofit2.Call
import retrofit2.http.GET


interface Endpoint {

    @GET("api/Map")
    fun getPost() : Call<List<Map>>
}

