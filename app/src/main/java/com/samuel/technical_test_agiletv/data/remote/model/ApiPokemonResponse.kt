package com.samuel.technical_test_agiletv.data.remote.model

/**
 * Shows the API response, containing information about pagination and the list of results
 * @property count Total number of Pokémon available in the API
 * @property next Show the next URL results page or NULL if there are no more results
 * @property previous Show the previous URL results page or NULL if there are no more results
 * @property results Show results list of Pokémon returned in the response.
 */

data class ApiPokemonResponse(
  val count: Int,
  val next: String?,
  val previous: String?,
  val results: List<ApiPokemonResults>
)

/**
 * Represents an item in the Pokémon API results list.
 * @property name Name of the Pokémon.
 * @property url URL with more information about the Pokémon.
 */

data class ApiPokemonResults(
  val name: String,
  val url: String
)