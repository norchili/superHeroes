package com.norbert.superheroes.domain

import android.util.Log
import com.norbert.superheroes.data.SuperHeroRepository
import com.norbert.superheroes.data.model.Connections

class GetConnections {

    private val repository= SuperHeroRepository()

    suspend operator fun invoke(id: String): Connections?{

        var connections: Connections? = null

        try {

            val response = repository.getConnections(id)

            if(response.isSuccessful){
                if (response.body()!=null){
                    connections = response.body()
                }

            }else{
                connections=null
                Log.e("Connections Is not Ok","Body ${response.body()}")
                Log.e("Connections Is not Ok","Code ${response.code()}")
            }

        }catch (error: Exception){
            Log.e("Error exception","$error")
            connections= null
        }

        return connections

    }
}