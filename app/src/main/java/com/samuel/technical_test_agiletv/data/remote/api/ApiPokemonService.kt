package com.samuel.technical_test_agiletv.data.remote.api

import com.samuel.technical_test_agiletv.data.remote.model.ApiPokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface defining the API service for retrieving a list of Pokémon.
 *
 * This interface uses Retrofit annotations to define how to make network requests
 * to the Pokémon API. It provides a method to fetch a paginated list of Pokémon.
 */

interface ApiPokemonService {
  /**
   * Retrieves a paginated list of Pokémon.
   *
   * This function makes a GET request to the "/pokemon" endpoint of the Pokémon API.
   * It supports pagination using the `offset` and `limit` query parameters.
   *
   * @param offset The offset for the list of Pokémon. Defaults to 0.
   * @param limit The maximum number of Pokémon to retrieve. Defaults to 150.
   * @return An [ApiPokemonResponse] object containing the list of Pokémon and other metadata.
   */
  @GET("pokemon")
  suspend fun getPokemons(
    @Query("offset") offset: Int = 0,
    @Query("limit") limit: Int = 150
  ): ApiPokemonResponse
}