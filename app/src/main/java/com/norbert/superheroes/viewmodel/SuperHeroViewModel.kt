package com.norbert.superheroes.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.norbert.superheroes.data.model.SuperHero
import com.norbert.superheroes.domain.GetSuperHeroes
import kotlinx.coroutines.launch

class SuperHeroViewModel: ViewModel() {
    val superHeroes= MutableLiveData<List<SuperHero>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val getSuperHeroes= GetSuperHeroes()
            val superHeroesList = getSuperHeroes()
            if(!superHeroesList.isNullOrEmpty()){
                superHeroes.postValue(superHeroesList)
                isLoading.postValue(false)

                //Resolver ya que si es nulo o esta vacio nunca se indicará que se deternga el loading progres
            }



        }
    }
}