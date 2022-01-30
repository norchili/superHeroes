package com.norbert.superheroes.domain

import android.util.Log
import com.norbert.superheroes.data.SuperHeroRepository
import com.norbert.superheroes.data.model.Biography
import com.norbert.superheroes.data.model.SuperHero

class GetBiography {

    private val repository= SuperHeroRepository()

    suspend operator fun invoke(id: String):Biography?{

        var biography: Biography? = null

            try {

                val response = repository.getBiography(id)

                if(response.isSuccessful){
                    if (response.body()!=null){
                        biography = response.body()
                    }

                }else{
                    biography=null
                    Log.e("biography Is not Ok","Body ${response.body()}")
                    Log.e("biography Is not Ok","Code ${response.code()}")
                }

            }catch (error: Exception){
                Log.e("Error exception","$error")
                biography= null
            }

        return biography

    }
}