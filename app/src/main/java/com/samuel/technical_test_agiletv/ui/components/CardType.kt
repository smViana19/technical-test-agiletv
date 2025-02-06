package com.samuel.technical_test_agiletv.ui.components

import androidx.annotation.DrawableRes
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
import androidx.compose.ui.unit.dp
import com.samuel.technical_test_agiletv.R


sealed class PokemonType(val color: Color, @DrawableRes val icon: Int, val displayName: String) {
  data object Water : PokemonType(Color(0xFF0B6DC3), R.drawable.water, "Water")
  data object Dragon : PokemonType(Color(0xFF7038F8), R.drawable.dragon, "Dragon")
  data object Electric : PokemonType(Color(0xFFF8D030), R.drawable.eletric, "Electric")
  data object Fairy : PokemonType(Color(0xFFEE99AC), R.drawable.fairy, "Fairy")
  data object Ghost : PokemonType(Color(0xFF705898), R.drawable.ghost, "Ghost")
  data object Fire : PokemonType(Color(0xFFF08030), R.drawable.fire, "Fire")
  data object Ice : PokemonType(Color(0xFF98D8D8), R.drawable.ice, "Ice")
  data object Grass : PokemonType(Color(0xFF78C850), R.drawable.grass, "Grass")
  data object Bug : PokemonType(Color(0xFFA8B820), R.drawable.bug, "Bug")
  data object Fighting : PokemonType(Color(0xFFC03028), R.drawable.fighting, "Fighting")
  data object Normal : PokemonType(Color(0xFFA8A878), R.drawable.normal, "Normal")
  data object Steel : PokemonType(Color(0xFFB8B8D0), R.drawable.steel, "Steel")
  data object Rock : PokemonType(Color(0xFFB8A038), R.drawable.rock, "Rock")
  data object Psychic : PokemonType(Color(0xFFF85888), R.drawable.psychic, "Psychic")
  data object Ground : PokemonType(Color(0xFFE0C068), R.drawable.ground, "Ground")
  data object Poison : PokemonType(Color(0xFFA040A0), R.drawable.poison, "Poison")
  data object Flying : PokemonType(Color(0xFFA890F0), R.drawable.flying, "Flying")

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
        text = pokemonType.displayName,
        color = Color.White,
      )
    }
  }
}


