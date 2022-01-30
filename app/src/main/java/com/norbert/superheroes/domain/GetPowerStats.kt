package com.norbert.superheroes.domain

import android.util.Log
import com.norbert.superheroes.data.SuperHeroRepository
import com.norbert.superheroes.data.model.PowerStats

class GetPowerStats {
    private val repository= SuperHeroRepository()

    suspend operator fun invoke(id: String): PowerStats?{

        var powerStats: PowerStats? = null

        try {

            val response = repository.getPowerStats(id)

            if(response.isSuccessful){
                if (response.body()!=null){
                    powerStats = response.body()
                }

            }else{
                powerStats=null
                Log.e("PowerStats Is not Ok","Body ${response.body()}")
                Log.e("PowerStats Is not Ok","Code ${response.code()}")
            }

        }catch (error: Exception){
            Log.e("Error exception","$error")
            powerStats= null
        }

        return powerStats

    }
}