package com.samuel.technical_test_agiletv.data.mocks

import com.samuel.technical_test_agiletv.data.remote.api.ApiPokemonService
import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonResponse

class ApiPokemonServiceMock: ApiPokemonService {
  override suspend fun getPokemons(offset: Int, limit: Int): ApiPokemonResponse {
    TODO("Not yet implemented")
  }
}