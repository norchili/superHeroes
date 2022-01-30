package com.norbert.superheroes.data.network

import com.norbert.superheroes.data.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("{id}")
    suspend fun getSuperHeroById(@Path("id") id: Int): Response<SuperHero>

    @GET("{id}/powerstats")
    suspend fun getPowerStats(@Path("id") id: String):Response<PowerStats>

    @GET("{id}/biography")
    suspend fun getBiography(@Path("id") id: String):Response<Biography>

    @GET("{id}/appearance")
    suspend fun getAppearance(@Path("id") id: String):Response<Appearance>

    @GET("{id}/work")
    suspend fun getWork(@Path("id") id: String):Response<Work>

    @GET("{id}/connections")
    suspend fun getConnections(@Path("id") id: String):Response<Connections>

}