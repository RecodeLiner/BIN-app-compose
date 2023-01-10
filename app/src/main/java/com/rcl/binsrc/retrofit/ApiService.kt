package com.rcl.binsrc.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/{bin}")
    fun getFromApi(@Path("bin") bin: String) : Call<ApiModel>
}