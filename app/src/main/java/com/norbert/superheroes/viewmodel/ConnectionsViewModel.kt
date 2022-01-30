package com.norbert.superheroes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.norbert.superheroes.data.model.Connections
import com.norbert.superheroes.domain.GetConnections
import kotlinx.coroutines.launch

class ConnectionsViewModel: ViewModel() {
    val connections= MutableLiveData<Connections>()
    val isLoading = MutableLiveData<Boolean>()
    fun onCreate(id: String){
        viewModelScope.launch {
            isLoading.postValue(true)
            val superHeroConnections= GetConnections().invoke(id)
            if(superHeroConnections!=null){
                connections.postValue(superHeroConnections!!)
                isLoading.postValue(false)
            }else{
                //Toast.makeText(coroutineContext,"Error al obtener la Biografía", Toast.LENGTH_SHORT).show()
                isLoading.postValue(false)
            }

        }
    }
}