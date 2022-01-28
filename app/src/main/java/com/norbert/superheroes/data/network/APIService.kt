package com.norbert.superheroes.data.network

import com.norbert.superheroes.data.model.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("{id}")
    suspend fun getSuperHeroById(@Path("id") id: Int): Response<Character>
}