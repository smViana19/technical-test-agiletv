package com.samuel.technical_test_agiletv.data.remote.api

import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiPokemonService {
  @GET("pokemon")
  suspend fun getPokemons(
    @Query("offset") offset: Int = 0,
    @Query("limit") limit: Int = 150
  ): ApiPokemonResponse
}