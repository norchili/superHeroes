package com.norbert.superheroes.data.model

import com.google.gson.annotations.SerializedName

data class SuperHero(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: String,
    val image: Image,
    val name: String,
    @SerializedName("powerstats")val powerStats: PowerStats,
    val response: String,
    val work: Work
)