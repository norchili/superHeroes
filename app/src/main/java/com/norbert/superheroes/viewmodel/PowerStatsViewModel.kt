package com.norbert.superheroes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.norbert.superheroes.data.model.PowerStats
import com.norbert.superheroes.domain.GetBiography
import com.norbert.superheroes.domain.GetPowerStats
import kotlinx.coroutines.launch

class PowerStatsViewModel:ViewModel() {
    val powerStats = MutableLiveData<PowerStats>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(id: String){
        viewModelScope.launch {
            isLoading.postValue(true)
            val superHeroPowerStats= GetPowerStats().invoke(id)
            if(superHeroPowerStats!=null){
                powerStats.postValue(superHeroPowerStats!!)
                isLoading.postValue(false)
            }else{
                //Toast.makeText(coroutineContext,"Error al obtener la Biografía", Toast.LENGTH_SHORT).show()
                isLoading.postValue(false)
            }

        }
    }
}