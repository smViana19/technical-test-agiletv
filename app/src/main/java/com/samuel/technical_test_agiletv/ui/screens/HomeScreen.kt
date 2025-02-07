package com.samuel.technical_test_agiletv.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.samuel.technical_test_agiletv.R
import com.samuel.technical_test_agiletv.data.mocks.ApiPokemonServiceMock
import com.samuel.technical_test_agiletv.ui.components.AppCard
import com.samuel.technical_test_agiletv.ui.components.AppLoader
import com.samuel.technical_test_agiletv.ui.navigation.NavigationScreens
import com.samuel.technical_test_agiletv.ui.theme.TechnicaltestagiletvTheme
import com.samuel.technical_test_agiletv.ui.viewmodels.HomeScreenViewModel

@Composable
fun HomeScreen(
  homeScreenViewModel: HomeScreenViewModel,
  navController: NavController
) {
  var searchText by remember { mutableStateOf("") }
  val focusManager = LocalFocusManager.current
  val pokemons by homeScreenViewModel.filteredPokemons.collectAsState()
  LaunchedEffect(Unit) {
    homeScreenViewModel.getAllPokemons()
  }
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
      .pointerInput(Unit) {
        detectTapGestures {
          focusManager.clearFocus()
        }
      }
  ) {

    Row(
      modifier = Modifier
        .fillMaxWidth()
        .zIndex(0.5f),
      horizontalArrangement = Arrangement.Center
    ) {
      OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(50),
        singleLine = true,
        value = searchText,
        colors = TextFieldDefaults.colors(
          focusedContainerColor = Color.Transparent,
          unfocusedContainerColor = Color.Transparent,
          focusedIndicatorColor = Color.Black,
          focusedLabelColor = Color.Black
        ),

        placeholder = {
          Text(text = stringResource(R.string.find_pokemon))
        },
        onValueChange = {
          searchText = it
          homeScreenViewModel.filterPokemons(searchText)
        },
        leadingIcon = {
          Icon(painter = painterResource(R.drawable.search), contentDescription = "Search icon")
        },
        trailingIcon = {
          if (searchText.isNotEmpty()) {
            IconButton(
              onClick = {
                searchText = ""
                homeScreenViewModel.filterPokemons(searchText)
                focusManager.clearFocus()
              }

            ) {
              Icon(
                painter = painterResource(R.drawable.ic_remove_24),
                contentDescription = "Clear text"
              )
            }
          }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
          onDone = { focusManager.clearFocus() }
        )
      )
    }
    Spacer(modifier = Modifier.height(16.dp))

    if (pokemons.isNotEmpty()) {
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .zIndex(1f)
      ) {
        items(pokemons) { pokemon ->
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(8.dp)
          ) {
            AppCard(text = pokemon.name, onClick = {
              navController.navigate("${NavigationScreens.POKEMON_DETAILS_SCREEN.name}?name=${pokemon.name}")
            })
          }
        }
      }
    } else {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(top = 24.dp)
          .zIndex(1f),
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.Center
        ) {
          Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Image(
              modifier = Modifier.size(200.dp),
              painter = painterResource(R.drawable.magikarp_not_found),
              contentDescription = "Not found image"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
              text = "Ops! Nenhum Pokémon foi encontrado.",
              textAlign = TextAlign.Center,
              fontSize = 20.sp,
              color = Color(0xFF333333)
            )
          }

        }
      }
    }


  }
  if (homeScreenViewModel.isLoading.value) {
    AppLoader()
  }
}


@Preview(
  showBackground = true,
//  device = "spec:width=1280dp,height=800dp,dpi=480"
)
@Composable
private fun HomeScreenPreview() {
  TechnicaltestagiletvTheme {
    val apiPokemonServiceMock = ApiPokemonServiceMock()
    val homeScreenViewModel = HomeScreenViewModel(apiPokemonServiceMock)
    val navController = rememberNavController()
    HomeScreen(homeScreenViewModel, navController)
  }
}