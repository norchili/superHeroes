package com.norbert.superheroes.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/api/10220704059488200/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}