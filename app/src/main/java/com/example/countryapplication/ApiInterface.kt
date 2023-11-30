package com.example.countryapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("all")
    fun getApiInterface() : Call<List<CountryModel>>

    @GET("all")
    fun searchname(
        @Query("name") name: String
    ):Call<List<CountryModel>>
}