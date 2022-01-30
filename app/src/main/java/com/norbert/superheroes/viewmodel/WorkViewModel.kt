package com.norbert.superheroes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.norbert.superheroes.data.model.Work
import com.norbert.superheroes.domain.GetWork
import kotlinx.coroutines.launch

class WorkViewModel: ViewModel() {

    val work= MutableLiveData<Work>()
    val isLoading = MutableLiveData<Boolean>()
    fun onCreate(id: String){
        viewModelScope.launch {
            isLoading.postValue(true)
            val superHeroWork= GetWork().invoke(id)
            if(superHeroWork!=null){
                work.postValue(superHeroWork!!)
                isLoading.postValue(false)
            }else{
                //Toast.makeText(coroutineContext,"Error al obtener la Biografía", Toast.LENGTH_SHORT).show()
                isLoading.postValue(false)
            }

        }
    }
}