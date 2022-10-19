package com.aminivan.dimakeup.network

import com.aminivan.dimakeup.model.ResponseDataMakeUpItem
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface RestfulApi {

    @GET("products.json")
    fun getAllMakup(): Call<List<ResponseDataMakeUpItem>>

}