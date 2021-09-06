package com.example.examplemvvm.repository

import com.example.examplemvvm.data.model.PokemonData

interface PokemonRepository {
    suspend fun getPokemons(limit: String, offset: String): PokemonData
}