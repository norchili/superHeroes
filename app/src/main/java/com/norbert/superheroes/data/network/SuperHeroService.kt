package com.norbert.superheroes.data.network

import com.norbert.superheroes.core.RetrofitHelper
import com.norbert.superheroes.data.model.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class SuperHeroService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getSuperHeroById(id: Int): Response<SuperHero>{
        return withContext(Dispatchers.IO){
            retrofit.create(APIService::class.java).getSuperHeroById(id)
        }
    }
}