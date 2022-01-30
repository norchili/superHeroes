package com.norbert.superheroes.domain

import android.util.Log
import com.norbert.superheroes.data.SuperHeroRepository
import com.norbert.superheroes.data.model.Appearance

class GetAppearance {

    private val repository= SuperHeroRepository()

    suspend operator fun invoke(id: String): Appearance?{

        var appearance: Appearance? = null

        try {

            val response = repository.getAppearance(id)

            if(response.isSuccessful){
                if (response.body()!=null){
                    appearance = response.body()
                }

            }else{
                appearance=null
                Log.e("Appearance Is not Ok","Body ${response.body()}")
                Log.e("Appearance Is not Ok","Code ${response.code()}")
            }

        }catch (error: Exception){
            Log.e("Error exception","$error")
            appearance= null
        }

        return appearance

    }
}