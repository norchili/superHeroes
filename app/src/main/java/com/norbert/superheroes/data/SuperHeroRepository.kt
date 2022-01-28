package com.norbert.superheroes.data

import com.norbert.superheroes.data.model.SuperHero
import com.norbert.superheroes.data.network.SuperHeroService
import retrofit2.Response

class SuperHeroRepository {
    private val api=SuperHeroService()
    suspend fun getSuperHeroById(id: Int): Response<SuperHero> {
        return api.getSuperHeroById(id)
    }
}