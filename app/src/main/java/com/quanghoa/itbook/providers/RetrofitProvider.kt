package com.quanghoa.itbook.providers

import com.quanghoa.itbook.services.ITBookService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val RootAPI = "https://api.itbook.store/1.0/"

fun createRetrofit(): Retrofit{
    return Retrofit.Builder()
        .baseUrl(RootAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun createBookService(): ITBookService{
    return createRetrofit().create(ITBookService::class.java)
}