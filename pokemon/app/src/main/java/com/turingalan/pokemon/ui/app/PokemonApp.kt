package com.turingalan.pokemon.ui.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.turingalan.pokemon.ui.detail.PokemonDetailScreen
import com.turingalan.pokemon.ui.list.PokemonListScreen
import com.turingalan.pokemon.ui.routes.PokemonDetailRoute
import com.turingalan.pokemon.ui.routes.PokemonListRoute

@Composable
fun PokemonApp(){
    val  navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PokemonListRoute
    ){
        //Primera pantalla: Lista de pokemons
        composable<PokemonListRoute>{
            PokemonListScreen(
                onPokemonClick = {pokemon ->
                    navController.navigate(
                        PokemonDetailRoute(
                            name = pokemon.name,
                            artworkId = pokemon.artworkId
                        )
                    )
                }
            )
        }

        //Segunda pantalla: Informacion de Pokemon
        composable<PokemonDetailRoute> {
            backStackEntry ->
            //Extraigo datos de la ruta
            val pokemonDetails = backStackEntry.toRoute<PokemonDetailRoute>()

            PokemonDetailScreen(
                name = pokemonDetails.name,
                artworkId = pokemonDetails.artworkId,
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}