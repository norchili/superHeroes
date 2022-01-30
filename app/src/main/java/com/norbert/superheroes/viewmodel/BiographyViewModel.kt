package com.norbert.superheroes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.norbert.superheroes.data.model.Biography
import com.norbert.superheroes.domain.GetBiography
import kotlinx.coroutines.launch

class BiographyViewModel:ViewModel() {
    val biography= MutableLiveData<Biography>()
    val isLoading = MutableLiveData<Boolean>()
    fun onCreate(id: String){
        viewModelScope.launch {
            isLoading.postValue(true)
            val superHeroBiography=GetBiography().invoke(id)
            if(superHeroBiography!=null){
                biography.postValue(superHeroBiography!!)
                isLoading.postValue(false)
            }else{
                //Toast.makeText(coroutineContext,"Error al obtener la Biografía", Toast.LENGTH_SHORT).show()
                isLoading.postValue(false)
            }

        }
    }
}