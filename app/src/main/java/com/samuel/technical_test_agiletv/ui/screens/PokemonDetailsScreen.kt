package com.samuel.technical_test_agiletv.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.samuel.technical_test_agiletv.R
import com.samuel.technical_test_agiletv.data.mocks.ApiPokemonDetailsServiceMock
import com.samuel.technical_test_agiletv.ui.components.AppLoader
import com.samuel.technical_test_agiletv.ui.components.CardPokemonType
import com.samuel.technical_test_agiletv.ui.components.PokemonType
import com.samuel.technical_test_agiletv.ui.navigation.NavigationScreens
import com.samuel.technical_test_agiletv.ui.theme.TechnicaltestagiletvTheme
import com.samuel.technical_test_agiletv.ui.viewmodels.PokemonDetailsViewModel
import com.samuel.technical_test_agiletv.utils.heightMask
import com.samuel.technical_test_agiletv.utils.weightMask

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailsScreen(
  name: String,
  pokemonDetailsViewModel: PokemonDetailsViewModel,
  navController: NavController
) {
  val pokemonImageUrl by pokemonDetailsViewModel.pokemonSprites
  LaunchedEffect(Unit) {
    pokemonDetailsViewModel.getPokemonDetails(name)
  }
  Scaffold(
    topBar = {
      TopAppBar(
        title = {},
        navigationIcon = {
          IconButton(
            onClick = {
              navController.navigate(NavigationScreens.HOME_SCREEN.name)
            }
          ) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon")
          }
        },
        colors = topAppBarColors(
          containerColor = Color.White,
          scrolledContainerColor = MaterialTheme.colorScheme.primary,
          navigationIconContentColor = Color.Black,
          titleContentColor = Color.Black,
          actionIconContentColor = Color.White
        )
      )
    },
    content = { paddingValues ->
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(paddingValues)
          .background(Color.White)
      ) {

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.Center
        ) {
          AsyncImage(
            model = pokemonImageUrl,
            contentDescription = "Pokemon Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
              .clip(CircleShape)
              .size(200.dp),
          )
        }
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
        ) {
          Text(
            text = pokemonDetailsViewModel.pokemonName.value,
            color = Color(0xFF333333),
            fontSize = 24.sp
          )
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
          modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp)
        ) {
          items(pokemonDetailsViewModel.pokemonTypes.value) { type ->
            val pokemonType = PokemonType.fromApiName(type.type.name)
            CardPokemonType(pokemonType)
          }
        }
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        )
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        ) {
          Column(
            modifier = Modifier
              .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = stringResource(R.string.height),
              fontSize = 18.sp,
              color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Card(
              modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = Color.Transparent),
              border = BorderStroke(1.dp, Color.LightGray),
            ) {
              Text(
                modifier = Modifier
                  .padding(16.dp),
                text = "${heightMask(pokemonDetailsViewModel.pokemonHeight.value)} m",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
              )
            }
          }
          Column(
            modifier = Modifier
              .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = stringResource(R.string.weight),
              fontSize = 18.sp,
              color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Card(
              modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = Color.Transparent),
              border = BorderStroke(1.dp, Color.LightGray),
            ) {
              Text(
                modifier = Modifier
                  .padding(16.dp),
                text = "${weightMask(pokemonDetailsViewModel.pokemonWeight.value)} kg",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
              )
            }
          }
          Column(
            modifier = Modifier
              .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = stringResource(R.string.abilitiy),
              fontSize = 18.sp,
              color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Card(
              modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = Color.Transparent),
              border = BorderStroke(1.dp, Color.LightGray),
            ) {
              Text(
                modifier = Modifier
                  .padding(16.dp),
                text = pokemonDetailsViewModel.pokemonAbilityName.value,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color.Black,
              )
            }
          }
        }
      }
      if (pokemonDetailsViewModel.isLoading.value) {
        AppLoader()
      }
    }
  )
}

@Preview(showBackground = true)
@Composable
private fun PokemonDetailsPreview() {
  TechnicaltestagiletvTheme {
    val name = "miutiu"
    val navController = rememberNavController()
    val apiPokemonDetailsService = ApiPokemonDetailsServiceMock()
    val pokemonDetailsViewModel = PokemonDetailsViewModel(apiPokemonDetailsService)
    PokemonDetailsScreen(name, pokemonDetailsViewModel, navController)
  }
}