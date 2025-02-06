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

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
  private val apiPokemonService: ApiPokemonService
) : ViewModel() {


  private val _filteredPokemons = MutableStateFlow<List<ApiPokemonResults>>(emptyList())
  val filteredPokemons : StateFlow<List<ApiPokemonResults>> = _filteredPokemons

  private val _pokemons = mutableStateOf<List<ApiPokemonResults>>(emptyList())
  val pokemons: MutableState<List<ApiPokemonResults>> = _pokemons
  private val _isLoading = mutableStateOf(false)
  val isLoading: MutableState<Boolean> = _isLoading

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

  fun filterPokemons(text: String) {
    _filteredPokemons.value = if(text.isEmpty()) {
      _pokemons.value
    } else {
      _pokemons.value.filter {
        it.name.contains(text)
      }
    }
  }


}