package com.example.countryapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        val BASE_URL = "https://restcountries.com/v2/"
        var retrofit : Retrofit? = null

        fun getApiClient() : Retrofit{
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}