package com.samuel.technical_test_agiletv.ui.viewmodels

import com.samuel.technical_test_agiletv.data.remote.api.ApiPokemonService
import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonResponse
import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonResults
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class HomeScreenViewModelTest {
  private val apiPokemonService: ApiPokemonService = mock()
  private lateinit var vm: HomeScreenViewModel

  @Before
  fun setup() {
    vm = HomeScreenViewModel(apiPokemonService)
  }
  @Test
  fun `should be fetch pokemons getAllPokemons`() = runTest {
    val pokemons = listOf(
      ApiPokemonResults(name = "mewtwo", url = "https://pokeapi.co/api/v2/pokemon/mewtwo"),
      ApiPokemonResults(name = "charizard", url = "https://pokeapi.co/api/v2/pokemon/charizard")
    )
    val response = ApiPokemonResponse(count = 2, next = null, previous = null, results = pokemons)
    whenever(apiPokemonService.getPokemons()).thenReturn(response)
    vm.getAllPokemons()

    advanceUntilIdle()
    println("Pokemons: ${vm.pokemons.value}")
    println("pokemonsstateflow: ${vm.filteredPokemons.value}")
    assertEquals(pokemons, vm.pokemons.value)
    assertEquals(pokemons, vm.filteredPokemons.value)
  }
}
