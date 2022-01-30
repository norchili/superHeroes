package com.norbert.superheroes.data.model

import java.io.Serializable


data class SuperHero(
    val id: String,
    val image: Image,
    val name: String,
    val response: String,
)

/*
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

 */