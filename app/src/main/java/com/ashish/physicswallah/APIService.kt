package com.ashish.physicswallah

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl("https://my-json-server.typicode.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface APIService {

    @GET("/easygautam/data/users")
    fun getUsers(): Call<List<UserObject>>

}

object Api {
    val retrofitService: APIService by lazy { retrofit.create(APIService::class.java) }
}