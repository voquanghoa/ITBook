package com.quanghoa.itbook.services

import com.quanghoa.itbook.models.Books
import retrofit2.Call
import retrofit2.http.GET

interface ITBookService {

    @GET("new")
    fun getNew(): Call<Books>
}