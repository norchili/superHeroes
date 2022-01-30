package com.norbert.superheroes.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.norbert.superheroes.R
import com.norbert.superheroes.data.model.Biography
import com.norbert.superheroes.data.model.PowerStats
import com.norbert.superheroes.data.model.SuperHero
import com.norbert.superheroes.databinding.FragmentSuperHeroInfoBinding
import com.norbert.superheroes.viewmodel.BiographyViewModel
import com.norbert.superheroes.viewmodel.PowerStatsViewModel
import com.squareup.picasso.Picasso


class SuperHeroInfoFragment : Fragment() {

    private lateinit var binding: FragmentSuperHeroInfoBinding
    private val biographyViewModel: BiographyViewModel by viewModels()
    private val powerStatsViewModel:PowerStatsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentSuperHeroInfoBinding.inflate(inflater,container,false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_super_hero_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("id")
        val name = arguments?.getString("name")
        val url = arguments?.getString("url")
        binding.tvName.text= name
        Picasso.get().load(url).into(binding.ivSuperHeroImage)

        biographyViewModel.onCreate(id?:"")
        powerStatsViewModel.onCreate(id?:"")

        biographyViewModel.biography.observe(this,{
            if(it!=null){
                updateBiography(it)
        }
        })

        powerStatsViewModel.powerStats.observe(this,{
            if(it!=null){
                updatePowerStats(it)
            }
        })

    }

    private fun updatePowerStats(powerStats: PowerStats) {
        binding.tvIntelligence.text=powerStats.intelligence
        binding.tvStrength.text=powerStats.strength
        binding.tvSpeed.text=powerStats.speed
        binding.tvDurability.text=powerStats.durability
        binding.tvPower.text=powerStats.power
        binding.tvCombat.text=powerStats.combat
    }

    private fun updateBiography(biography: Biography) {
            binding.tvFullName.text=biography.fullName
        binding.tvAlterEgos.text=biography.alterEgos
        binding.tvAliases.text= "${biography.aliases}"
        binding.tvAlignment.text=biography.alignment
        binding.tvPlaceOfBirth.text=biography.placeOfBirth
        binding.tvFirstAppearance.text=biography.firstAppearance
        binding.tvPublisher.text=biography.publisher
    }


}