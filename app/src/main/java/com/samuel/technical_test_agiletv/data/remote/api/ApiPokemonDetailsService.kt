package com.samuel.technical_test_agiletv.data.remote.api

import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface defining the API service for retrieving Pokémon details.
 *
 * This interface uses Retrofit annotations to define how to make network requests
 * to the Pokémon API. It provides a method to fetch detailed information about a
 * specific Pokémon by its name.
 */

interface ApiPokemonDetailsService {
  /**
   * Retrieves detailed information about a Pokémon by its name.
   *
   * This function makes a GET request to the "/pokemon/{name}" endpoint of the
   * Pokémon API. The `{name}` part of the URL is replaced with the value of the
   * [name] parameter.
   *
   * @param name The name of the Pokémon to retrieve details for.
   * @return An [ApiPokemonDetailResponse] object containing the Pokémon's details.
   */
  @GET("pokemon/{name}")
  suspend fun getPokemonDetails(
    @Path("name") name: String,
  ): ApiPokemonDetailResponse
}