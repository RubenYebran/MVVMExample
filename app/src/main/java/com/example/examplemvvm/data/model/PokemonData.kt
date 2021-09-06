package com.example.examplemvvm.data.model

import com.google.gson.annotations.SerializedName

data class PokemonData(
    @SerializedName("results")
    val results: List<Pokemon> = listOf()
)