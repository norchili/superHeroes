package com.norbert.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.norbert.superheroes.databinding.ActivityMainBinding
import com.norbert.superheroes.domain.GetSuperHeroById
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSuperheroById()

    }

    private fun getSuperheroById() {
        CoroutineScope(Dispatchers.Main).launch {
            val getSuperHeroById=GetSuperHeroById()
            val superHero = getSuperHeroById(1)

            if (superHero!=null){
                Log.e("Super Heroe", "Super Heroe: $superHero")

            }else{
                Log.e("Super Heroe", "Super Heroe: $superHero es null")
            }

        }
    }
}