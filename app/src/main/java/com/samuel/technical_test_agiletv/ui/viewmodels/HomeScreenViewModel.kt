package com.samuel.technical_test_agiletv.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuel.technical_test_agiletv.data.remote.api.ApiPokemonService
import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the HomeScreen, responsible for managing the list of Pokémon and their filtering.
 *
 * This ViewModel fetch Pokémon data from the [ApiPokemonService] and exposes it to the UI
 * through [StateFlow] and [MutableState]. It also handles filtering the list of Pokémon based on user input.
 *
 * @property apiPokemonService The service used to fetch Pokémon data from the API.
 */

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
  private val apiPokemonService: ApiPokemonService
) : ViewModel() {

//  val pokemonsSteFlow: StateFlow<List<ApiPokemonResults>> get() = _filteredPokemons


  private val _filteredPokemons = MutableStateFlow<List<ApiPokemonResults>>(emptyList())
  val filteredPokemons: StateFlow<List<ApiPokemonResults>> = _filteredPokemons

  private val _pokemons = mutableStateOf<List<ApiPokemonResults>>(emptyList())
  val pokemons: MutableState<List<ApiPokemonResults>> = _pokemons

  private val _isLoading = mutableStateOf(false)
  val isLoading: MutableState<Boolean> = _isLoading

  /**
   * Fetches all Pokémon data from the [ApiPokemonService].
   *
   * This function updates the [pokemons] and [filteredPokemons] states with the fetched data.
   * It also manages the [isLoading] state to indicate when the data is being loaded.
   */

  fun getAllPokemons() {
    viewModelScope.launch {
      try {
        _isLoading.value = true
        val response = apiPokemonService.getPokemons()
        _pokemons.value = response.results
        _filteredPokemons.value = response.results
      } catch (e: Exception) {
        e.printStackTrace()
      } finally {
        _isLoading.value = false
      }
    }
  }

  /**
   * Filters the list of Pokémon based on the given text.
   *
   * This function updates the [filteredPokemons] state with the filtered list.
   * If the input text is empty, it displays all Pokémon.
   *
   * @param text The text to filter the Pokémon by (case-sensitive FALSE).
   */

  fun filterPokemons(text: String) {
    _filteredPokemons.value = if (text.isEmpty()) {
      _pokemons.value
    } else {
      _pokemons.value.filter {
        it.name.contains(text, ignoreCase = true)
      }
    }
  }
}