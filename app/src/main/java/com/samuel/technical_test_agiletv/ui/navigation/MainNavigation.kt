package com.samuel.technical_test_agiletv.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.samuel.technical_test_agiletv.ui.screens.HomeScreen
import com.samuel.technical_test_agiletv.ui.screens.PokemonDetailsScreen
import com.samuel.technical_test_agiletv.ui.viewmodels.HomeScreenViewModel
import com.samuel.technical_test_agiletv.ui.viewmodels.PokemonDetailsViewModel

@Composable
fun MainNavigation() {
  val navController = rememberNavController()
  val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
  val pokemonDetailsViewModel: PokemonDetailsViewModel = hiltViewModel()

  NavHost(
    navController = navController,
    startDestination = NavigationScreens.HOME_SCREEN.name
  ) {

    composable(route = NavigationScreens.HOME_SCREEN.name) {
      HomeScreen(homeScreenViewModel, navController)
    }

    composable(
      route = "${NavigationScreens.POKEMON_DETAILS_SCREEN.name}?name={name}",
      arguments = listOf(
        navArgument("name") {
          type = NavType.StringType
          defaultValue = ""
        }
      )
    ) { navBackStackEntry ->
      val name = navBackStackEntry.arguments?.getString("name") ?: ""
      PokemonDetailsScreen(name, pokemonDetailsViewModel, navController)
    }

  }
}

@Preview
@Composable
private fun MainNavigationPreview() {
  MainNavigation()
}