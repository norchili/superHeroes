package com.norbert.superheroes.domain

import android.util.Log
import com.norbert.superheroes.data.SuperHeroRepository
import com.norbert.superheroes.data.model.SuperHero

class GetSuperHeroes {
    private val repository= SuperHeroRepository()

    suspend operator fun invoke(page: Int):List<SuperHero>{

        val superHeroList = mutableListOf<SuperHero>()
        //Definimos los limites de la pagina
        //Solicita 10 super heroes a la API
        val start = (page - 1 ) * 10 + 1
        val limit = page * 10

        for (i in start..limit){
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