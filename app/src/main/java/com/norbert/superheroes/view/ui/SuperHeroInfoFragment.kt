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
import com.norbert.superheroes.data.model.*
import com.norbert.superheroes.databinding.FragmentSuperHeroInfoBinding
import com.norbert.superheroes.viewmodel.*
import com.squareup.picasso.Picasso


class SuperHeroInfoFragment : Fragment() {

    private lateinit var binding: FragmentSuperHeroInfoBinding
    private val biographyViewModel: BiographyViewModel by viewModels()
    private val powerStatsViewModel:PowerStatsViewModel by viewModels()
    private val appearanceViewModel:AppearanceViewModel by viewModels()
    private val workViewModel:WorkViewModel by viewModels()
    private val connectionsViewModel:ConnectionsViewModel by viewModels()

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
        appearanceViewModel.onCreate(id?:"")
        workViewModel.onCreate(id?:"")
        connectionsViewModel.onCreate(id?:"")

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

        appearanceViewModel.appearance.observe(this,{
            if(it!=null){
                updateAppearance(it)
            }
        })

        workViewModel.work.observe(this,{
            if(it!=null){
                updateWork(it)
            }
        })

        connectionsViewModel.connections.observe(this,{
            if(it!=null){
                updateConnections(it)
            }
        })

    }

    private fun updateConnections(connections: Connections) {
        binding.tvGroupAffiliation.text = connections.groupAffiliation
        binding.tvRelatives.text = connections.relatives
    }

    private fun updateWork(work: Work) {
        binding.tvOccupation.text = work.occupation
        binding.tvBase.text = work.base
    }

    private fun updateAppearance(appearance: Appearance) {
        binding.tvGender.text = appearance.gender
        binding.tvRace.text= appearance.race
        binding.tvHeight.text = appearance.height.toString()
        binding.tvWeight.text = appearance.weight.toString()
        binding.tvEyeColor.text = appearance.eyeColor
        binding.tvHairColor.text = appearance.hairColor
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