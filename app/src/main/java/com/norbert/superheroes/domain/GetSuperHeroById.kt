package com.norbert.superheroes.domain

import android.util.Log
import com.norbert.superheroes.data.SuperHeroRepository
import com.norbert.superheroes.data.model.Character

class GetSuperHeroById {
    private val repository= SuperHeroRepository()

    suspend operator fun invoke(id:Int):Character?{
        try {

            val response = repository.getSuperHeroById(id)

            if(response.isSuccessful){
                Log.e("Is Ok","Body ${response.body()}")
                Log.e("Is Ok","Code ${response.code()}")
                return null
            }else{
                Log.e("Is not Ok","Body ${response.body()}")
                Log.e("Is not Ok","Code ${response.code()}")
                return null
            }

        }catch (error: Exception){
            Log.e("Error exception","$error")
            return null
        }
    }
}