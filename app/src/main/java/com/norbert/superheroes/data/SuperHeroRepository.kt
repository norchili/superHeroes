package com.norbert.superheroes.data

import com.norbert.superheroes.data.model.*
import com.norbert.superheroes.data.network.SuperHeroService
import retrofit2.Response

class SuperHeroRepository {
    private val api=SuperHeroService()
    suspend fun getSuperHeroById(id: Int): Response<SuperHero> {
        return api.getSuperHeroById(id)
    }

    suspend fun getBiography(id: String): Response<Biography>{
        return api.getBiography(id)
    }

    suspend fun getPowerStats(id: String): Response<PowerStats>{
        return api.getPowerStats(id)
    }
    suspend fun getAppearance(id: String): Response<Appearance>{
        return api.getAppearance(id)
    }
    suspend fun getWork(id: String): Response<Work>{
        return api.getWork(id)
    }
    suspend fun getConnections(id: String): Response<Connections>{
        return api.getConnections(id)
    }
}