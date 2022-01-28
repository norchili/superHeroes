package com.norbert.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.norbert.superheroes.databinding.ActivityMainBinding
import com.norbert.superheroes.view.adapter.SuperHeroAdapter
import com.norbert.superheroes.viewmodel.SuperHeroViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val superHeroViewModel: SuperHeroViewModel by viewModels()
    private lateinit var superHeroAdapter: SuperHeroAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        superHeroViewModel.onCreate()

        superHeroAdapter= SuperHeroAdapter()
        binding.rvSuperHeroes.apply {
            layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
            adapter = superHeroAdapter
        }
        superHeroViewModel.superHeroes.observe(this, {
            it.forEach { superHero->
                Log.e("Super Hero View Model","Id: ${superHero.id} ${superHero.name}")
            }

            if (!it.isNullOrEmpty()){
                superHeroAdapter.updateData(it)
            }
        })

        superHeroViewModel.isLoading.observe(this, {
            Log.e("isLoading","$it")
        })

    }


}