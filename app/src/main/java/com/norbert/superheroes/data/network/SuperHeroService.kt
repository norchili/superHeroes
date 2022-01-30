package com.norbert.superheroes.data.network

import com.norbert.superheroes.core.RetrofitHelper
import com.norbert.superheroes.data.model.*
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

    suspend fun getBiography(id: String): Response<Biography>{
        return withContext(Dispatchers.IO){
            retrofit.create(APIService::class.java).getBiography(id)
        }
    }

    suspend fun getPowerStats(id: String): Response<PowerStats>{
        return withContext(Dispatchers.IO){
            retrofit.create(APIService::class.java).getPowerStats(id)
        }
    }

    suspend fun getAppearance(id: String): Response<Appearance>{
        return withContext(Dispatchers.IO){
            retrofit.create(APIService::class.java).getAppearance(id)
        }
    }

    suspend fun getWork(id: String): Response<Work>{
        return withContext(Dispatchers.IO){
            retrofit.create(APIService::class.java).getWork(id)
        }
    }

    suspend fun getConnections(id: String): Response<Connections>{
        return withContext(Dispatchers.IO){
            retrofit.create(APIService::class.java).getConnections(id)
        }
    }
}