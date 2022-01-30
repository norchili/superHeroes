package com.norbert.superheroes.domain

import android.util.Log
import com.norbert.superheroes.data.SuperHeroRepository
import com.norbert.superheroes.data.model.SuperHero

class GetSuperHeroes {
    private val repository= SuperHeroRepository()

    suspend operator fun invoke():List<SuperHero>{

        val superHeroList = mutableListOf<SuperHero>()

        for (i in 1..5){
            try {

                val response = repository.getSuperHeroById(i)

                if(response.isSuccessful){
                    if (response.body()!=null){
                        val superHero = response.body()!!
                        superHeroList.add(superHero)
                        //Log.e("Is Ok","Id ${superHero.id} ${superHero.name}")
                    }

                }else{
                    Log.e("Is not Ok","Body ${response.body()}")
                    Log.e("Is not Ok","Code ${response.code()}")
                }

            }catch (error: Exception){
                Log.e("Error exception","$error")
            }
        }
        return superHeroList

    }
}