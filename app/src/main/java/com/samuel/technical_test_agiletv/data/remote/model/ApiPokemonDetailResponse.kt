package com.samuel.technical_test_agiletv.data.remote.model

import com.google.gson.annotations.SerializedName

data class ApiPokemonDetailResponse(
  @SerializedName("id")
  val id: Int,
  @SerializedName("name")
  val name: String,
  @SerializedName("abilities")
  val abilities: List<Abilities>,
  @SerializedName("height")
  val height: Int,
  @SerializedName("weight")
  val weight: Int,
  @SerializedName("types")
  val types: List<PokemonType>,
  @SerializedName("sprites")
  val sprites: PokemonSprites
)

data class PokemonType(
  @SerializedName("slot")
  val slot: Int,
  @SerializedName("type")
  val type: TypeDetail
)

data class Abilities(
  @SerializedName("ability")
  val abilities: Ability,
  @SerializedName("is_hidden")
  val isHidden: Boolean,
  @SerializedName("slot")
  val slot: Int
)

data class Ability(
  @SerializedName("name")
  val name: String,
  @SerializedName("url")
  val url: String,
)

data class TypeDetail(
  @SerializedName("name")
  val name: String,
)

data class PokemonSprites(
  @SerializedName("front_default")
  val frontDefault: String,
  @SerializedName("back_default")
  val backDefault: String
)





