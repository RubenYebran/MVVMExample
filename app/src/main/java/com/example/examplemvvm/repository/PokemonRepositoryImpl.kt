package com.example.examplemvvm.repository

import com.example.examplemvvm.data.model.PokemonData
import com.example.examplemvvm.data.remote.RandomPokemonDataSource

class PokemonRepositoryImpl(private val dataSource: RandomPokemonDataSource) : PokemonRepository  { //Implementacion de la interfaz.

    override suspend fun getPokemons(limit:String, offset: String): PokemonData = dataSource.getPokemons(limit,offset)

}