package com.example.examplemvvm.data.remote

import com.example.examplemvvm.data.model.PokemonData
import com.example.examplemvvm.repository.WebService

class RandomPokemonDataSource(private val webService: WebService) {
    suspend fun getPokemons(limit:String, offset:String): PokemonData = webService.getPokemons(limit,offset)
}