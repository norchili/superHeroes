package com.norbert.superheroes.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.norbert.superheroes.R
import com.norbert.superheroes.data.model.SuperHero
import com.norbert.superheroes.databinding.FragmentSuperHeroListBinding
import com.norbert.superheroes.view.adapter.SuperHeroAdapter
import com.norbert.superheroes.viewmodel.SuperHeroViewModel


class SuperHeroListFragment : Fragment() {
    private lateinit var binding:FragmentSuperHeroListBinding
    private val superHeroViewModel: SuperHeroViewModel by viewModels()
    private lateinit var superHeroAdapter: SuperHeroAdapter
    private lateinit var navController: NavController

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
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        superHeroAdapter= SuperHeroAdapter { superHero->
            onItemSelected(superHero)
        }

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

    private fun onItemSelected(superHero: SuperHero){
        Toast.makeText(context, superHero.name, Toast.LENGTH_SHORT).show()
        val bundle = bundleOf("id" to superHero.id, "name" to superHero.name, "url" to superHero.image.url)

        navController.navigate(R.id.action_superHeroListFragment_to_superHeroInfoFragment, bundle)
    }
}