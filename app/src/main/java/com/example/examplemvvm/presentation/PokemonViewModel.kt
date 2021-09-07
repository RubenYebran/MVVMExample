package com.example.examplemvvm.presentation

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm.core.Resource
import com.example.examplemvvm.data.model.Pokemon
import com.example.examplemvvm.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*


class PokemonViewModel(private val repo: PokemonRepository) : ViewModel() {

    fun fetchPokemons(limit: String, offset: String) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getPokemons(limit, offset)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}