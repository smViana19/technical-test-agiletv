package com.samuel.technical_test_agiletv.data.remote.api

import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiPokemonDetailsService {
  @GET("pokemon/{name}")
  suspend fun getPokemonDetails(
    @Path("name") name: String,
  ): ApiPokemonDetailResponse
}