package com.norbert.superheroes.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.norbert.superheroes.databinding.FragmentSuperHeroListBinding
import com.norbert.superheroes.view.adapter.SuperHeroAdapter
import com.norbert.superheroes.viewmodel.SuperHeroViewModel


class SuperHeroListFragment : Fragment() {
    private lateinit var binding:FragmentSuperHeroListBinding
    private val superHeroViewModel: SuperHeroViewModel by viewModels()
    private lateinit var superHeroAdapter: SuperHeroAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSuperHeroListBinding.inflate(inflater,container, false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_super_hero_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superHeroViewModel.onCreate()

        superHeroAdapter= SuperHeroAdapter()
        binding.rvSuperHeroes.apply {
            layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
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
            binding.loading.isVisible=it
            Log.e("isLoading","$it")
        })
    }
}