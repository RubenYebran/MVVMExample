package com.example.examplemvvm.repository

import com.example.examplemvvm.application.ApplicationConstants
import com.example.examplemvvm.data.model.PokemonData
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET(ApplicationConstants.PATH)
    suspend fun getPokemons(
        @Query("limit") limit: String,
        @Query("offset") offset: String
    ): PokemonData

}