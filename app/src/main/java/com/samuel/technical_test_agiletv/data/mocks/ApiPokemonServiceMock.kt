package com.samuel.technical_test_agiletv.data.mocks

import com.samuel.technical_test_agiletv.data.remote.api.ApiPokemonService
import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonResponse
import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonResults

class ApiPokemonServiceMock : ApiPokemonService {
  override suspend fun getPokemons(offset: Int, limit: Int): ApiPokemonResponse {
    return ApiPokemonResponse(
      count = 2,
      next = null,
      previous = null,
      results = listOf(
        ApiPokemonResults("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
        ApiPokemonResults("squirtle", "https://pokeapi.co/api/v2/pokemon/7/")
      )
    )
  }
}