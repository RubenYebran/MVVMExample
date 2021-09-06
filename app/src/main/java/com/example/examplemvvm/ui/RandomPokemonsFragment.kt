package com.example.examplemvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.examplemvvm.R
import com.example.examplemvvm.core.Resource
import com.example.examplemvvm.data.model.Pokemon
import com.example.examplemvvm.data.remote.RandomPokemonDataSource
import com.example.examplemvvm.databinding.FragmentRandomPokemonsBinding
import com.example.examplemvvm.presentation.PokemonViewModel
import com.example.examplemvvm.presentation.PokemonViewModelFactory
import com.example.examplemvvm.repository.PokemonRepositoryImpl
import com.example.examplemvvm.repository.Retrofit
import kotlin.random.Random


class RandomPokemonsFragment : Fragment(R.layout.fragment_random_pokemons) {

    private lateinit var binding: FragmentRandomPokemonsBinding

    private val viewModel by viewModels<PokemonViewModel> {
        PokemonViewModelFactory(
            PokemonRepositoryImpl(
                RandomPokemonDataSource(
                    Retrofit.webservice
                )
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRandomPokemonsBinding.bind(view)

        binding.btnGetRandomPokemon.setOnClickListener {
            getRandomPokemon()
        }
    }

    private fun getRandomPokemon() {
        var randomNumber: String = (1..898).random().toString()
        val pokemonImageNumber: String = randomNumber
        randomNumber += "/"

        viewModel.fetchPokemons("1",randomNumber).observe(viewLifecycleOwner,{
            it?.let {
                when (it) {
                is Resource.Loading -> {
                    println("Loading...")
                }
                is Resource.Success -> {
                    binding.tvRandomPokemon.text = it.data.results[0].name

                    Glide.with(this)
                        .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonImageNumber}.png")
                        .centerCrop().into(binding.ivPokemon)
                }
                is Resource.Failure -> {
                    Log.d("Error", "${it.exception}")
                }
            }}
        })
    }
}