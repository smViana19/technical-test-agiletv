package com.samuel.technical_test_agiletv.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuel.technical_test_agiletv.data.remote.api.ApiPokemonDetailsService
import com.samuel.technical_test_agiletv.data.remote.model.PokemonType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the Pokemon Details Screen, responsible for fetching and managing the details of a specific Pokémon.
 *
 * This ViewModel interacts with the [ApiPokemonDetailsService] to retrieve detailed information about a Pokémon
 * and exposes this data to the UI through [MutableState].
 *
 * @property apiPokemonDetailsService The service used to fetch Pokémon details from the API.
 */

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
  private val apiPokemonDetailsService: ApiPokemonDetailsService
) : ViewModel() {

  private val _pokemonName = mutableStateOf("")
  val pokemonName: MutableState<String> = _pokemonName

  private val _pokemonHeight = mutableStateOf(0)
  val pokemonHeight: MutableState<Int> = _pokemonHeight

  private val _pokemonWeight = mutableStateOf(0)
  val pokemonWeight: MutableState<Int> = _pokemonWeight

  private val _pokemonSprites = mutableStateOf("")
  val pokemonSprites: MutableState<String> = _pokemonSprites

  private val _pokemonAbilityName = mutableStateOf("")
  val pokemonAbilityName: MutableState<String> = _pokemonAbilityName

  private val _pokemonTypes = mutableStateOf<List<PokemonType>>(emptyList())
  val pokemonTypes: MutableState<List<PokemonType>> = _pokemonTypes

  private val _isLoading = mutableStateOf(false)
  val isLoading: MutableState<Boolean> = _isLoading


  /**
   * Fetches the details of a Pokémon with the given name.
   *
   * This function retrieves the Pokémon's details from the [ApiPokemonDetailsService] and updates the
   * corresponding states: [pokemonSprites], [pokemonName], [pokemonHeight], [pokemonWeight],
   * [pokemonTypes], and [pokemonAbilityName]. It also manages the [isLoading] state to indicate
   * when the data is being loaded.
   *
   * The function iterates through the Pokémon's abilities and sets the [pokemonAbilityName] to the
   * name of the first non-hidden ability found.
   *
   * @param name The name of the Pokémon to fetch details for.
   */

  fun getPokemonDetails(name: String) {
    viewModelScope.launch {
      try {
        _isLoading.value = true
        val response = apiPokemonDetailsService.getPokemonDetails(name)
        _pokemonSprites.value = response.sprites.frontDefault
        _pokemonName.value = response.name
        _pokemonHeight.value = response.height
        _pokemonWeight.value = response.weight
        _pokemonTypes.value = response.types

        val abilityNotHidden = response.abilities.filter { ability ->
          !ability.isHidden
        }

        for (abilityName in abilityNotHidden) {
          _pokemonAbilityName.value = abilityName.abilities.name
        }

      } catch (e: Exception) {
        e.printStackTrace()
      } finally {
        _isLoading.value = false
      }
    }

  }
}