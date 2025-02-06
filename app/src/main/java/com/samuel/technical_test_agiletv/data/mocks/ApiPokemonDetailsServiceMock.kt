package com.samuel.technical_test_agiletv.data.mocks

import com.samuel.technical_test_agiletv.data.remote.api.ApiPokemonDetailsService
import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonDetailResponse

class ApiPokemonDetailsServiceMock: ApiPokemonDetailsService {
  override suspend fun getPokemonDetails(name: String): ApiPokemonDetailResponse {
    TODO("Not yet implemented")
  }
}