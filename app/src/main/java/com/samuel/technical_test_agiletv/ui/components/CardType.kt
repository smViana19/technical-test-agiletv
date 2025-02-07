package com.samuel.technical_test_agiletv.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.samuel.technical_test_agiletv.R


sealed class PokemonType(val color: Color, @DrawableRes val icon: Int, @StringRes val displayName: Int) {
  data object Water : PokemonType(Color(0xFF0B6DC3), R.drawable.water, R.string.type_water)
  data object Dragon : PokemonType(Color(0xFF7038F8), R.drawable.dragon, R.string.type_dragon)
  data object Electric : PokemonType(Color(0xFFF8D030), R.drawable.eletric, R.string.type_electric)
  data object Fairy : PokemonType(Color(0xFFEE99AC), R.drawable.fairy, R.string.type_fairy)
  data object Ghost : PokemonType(Color(0xFF705898), R.drawable.ghost, R.string.type_ghost)
  data object Fire : PokemonType(Color(0xFFF08030), R.drawable.fire, R.string.type_fire)
  data object Ice : PokemonType(Color(0xFF98D8D8), R.drawable.ice, R.string.type_ice)
  data object Grass : PokemonType(Color(0xFF78C850), R.drawable.grass, R.string.type_grass)
  data object Bug : PokemonType(Color(0xFFA8B820), R.drawable.bug, R.string.type_bug)
  data object Fighting : PokemonType(Color(0xFFC03028), R.drawable.fighting, R.string.type_fighting)
  data object Normal : PokemonType(Color(0xFFA8A878), R.drawable.normal, R.string.type_normal)
  data object Steel : PokemonType(Color(0xFFB8B8D0), R.drawable.steel, R.string.type_steel)
  data object Rock : PokemonType(Color(0xFFB8A038), R.drawable.rock, R.string.type_rock)
  data object Psychic : PokemonType(Color(0xFFF85888), R.drawable.psychic, R.string.type_psychic)
  data object Ground : PokemonType(Color(0xFFE0C068), R.drawable.ground, R.string.type_ground)
  data object Poison : PokemonType(Color(0xFFA040A0), R.drawable.poison, R.string.type_poison)
  data object Flying : PokemonType(Color(0xFFA890F0), R.drawable.flying, R.string.type_flying)

  companion object {
    fun fromName(name: String): PokemonType {
      return when (name.lowercase()) {
        "water" -> Water
        "dragon" -> Dragon
        "electric" -> Electric
        "fairy" -> Fairy
        "ghost" -> Ghost
        "fire" -> Fire
        "ice" -> Ice
        "grass" -> Grass
        "bug" -> Bug
        "fighting" -> Fighting
        "normal" -> Normal
        "steel" -> Steel
        "rock" -> Rock
        "psychic" -> Psychic
        "ground" -> Ground
        "poison" -> Poison
        "flying" -> Flying
        else -> Normal
      }
    }
  }
}

@Composable
fun CardPokemonType(pokemonType: PokemonType) {
  Card(
    shape = RoundedCornerShape(50),
    colors = CardDefaults.cardColors(containerColor = pokemonType.color),
    modifier = Modifier
      .padding(4.dp)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
      Icon(
        modifier = Modifier.size(24.dp),
        painter = painterResource(id = pokemonType.icon),
        contentDescription = "",
        tint = Color.White,
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = stringResource(pokemonType.displayName),
        color = Color.White,
      )
    }
  }
}


