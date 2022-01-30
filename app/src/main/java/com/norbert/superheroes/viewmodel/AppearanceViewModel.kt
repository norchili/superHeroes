package com.norbert.superheroes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.norbert.superheroes.data.model.Appearance
import com.norbert.superheroes.domain.GetAppearance
import kotlinx.coroutines.launch

class AppearanceViewModel: ViewModel() {

    val appearance= MutableLiveData<Appearance>()
    val isLoading = MutableLiveData<Boolean>()
    fun onCreate(id: String){
        viewModelScope.launch {
            isLoading.postValue(true)
            val superHeroAppearance= GetAppearance().invoke(id)
            if(superHeroAppearance!=null){
                appearance.postValue(superHeroAppearance!!)
                isLoading.postValue(false)
            }else{
                //Toast.makeText(coroutineContext,"Error al obtener la Biografía", Toast.LENGTH_SHORT).show()
                isLoading.postValue(false)
            }

        }
    }
}