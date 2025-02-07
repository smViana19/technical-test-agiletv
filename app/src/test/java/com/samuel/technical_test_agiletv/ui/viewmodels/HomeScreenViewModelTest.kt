//package com.samuel.technical_test_agiletv.ui.viewmodels
//
//import com.samuel.technical_test_agiletv.data.remote.api.ApiPokemonService
//import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonResponse
//import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonResults
//import io.mockk.coEvery
//import io.mockk.mockk
//import junit.framework.TestCase.assertEquals
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.advanceUntilIdle
//import kotlinx.coroutines.test.runTest
//import org.junit.Test
//
//
//class HomeScreenViewModelTest {
//
//  private val apiPokemonService: ApiPokemonService = mockk()
//  private val viewModel = HomeScreenViewModel(apiPokemonService)
//
//  @OptIn(ExperimentalCoroutinesApi::class)
//  @Test
//  fun `When fetching pokemons, the list should be filled`() = runTest {
//    coEvery { apiPokemonService.getPokemons(any(), any()) } returns ApiPokemonResponse(
//      count = 2,
//      next = null,
//      previous = null,
//      results = listOf(
//        ApiPokemonResults("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
//        ApiPokemonResults("squirtle", "https://pokeapi.co/api/v2/pokemon/7/")
//      )
//    )
//    viewModel.getAllPokemons()
//    advanceUntilIdle()
//
//    assertEquals(2, viewModel.pokemons.value.size)
//    assertEquals("bulbasaur", viewModel.pokemons.value[0].name)
//  }
//}