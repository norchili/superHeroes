package com.norbert.superheroes.domain

import android.util.Log
import com.norbert.superheroes.data.SuperHeroRepository
import com.norbert.superheroes.data.model.Work

class GetWork {

    private val repository= SuperHeroRepository()

    suspend operator fun invoke(id: String): Work?{

        var work: Work? = null

        try {

            val response = repository.getWork(id)

            if(response.isSuccessful){
                if (response.body()!=null){
                    work = response.body()
                }

            }else{
                work=null
                Log.e("work Is not Ok","Body ${response.body()}")
                Log.e("work Is not Ok","Code ${response.code()}")
            }

        }catch (error: Exception){
            Log.e("Error exception","$error")
            work= null
        }

        return work

    }
}