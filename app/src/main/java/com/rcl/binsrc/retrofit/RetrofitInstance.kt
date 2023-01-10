package com.rcl.binsrc.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BaseUrl = "https://lookup.binlist.net"
    private val client = OkHttpClient.Builder()
        .build()
    private val RetrofitAPi: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BaseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val retrofitRq: ApiService = RetrofitAPi.create(ApiService::class.java)
}