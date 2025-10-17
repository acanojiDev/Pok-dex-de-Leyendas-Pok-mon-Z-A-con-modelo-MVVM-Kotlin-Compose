package com.turingalan.pokemon.ui.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.turingalan.pokemon.data.model.Pokemon
import com.turingalan.pokemon.data.repository.PokemonInMemoryRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(
    onPokemonClick: (Pokemon) -> Unit,
    viewModel: PokemonListViewModel = hiltViewModel() //falta algo en graddle
){
    val pokemons: List<Pokemon> = PokemonInMemoryRepository.readAll()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Pokedex")}
            )
        }
    ) {
        paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(
                items = pokemons,
                key = {it.name}
            ){pokemon ->
                PokemonItem(
                    pokemon = pokemon,
                    onClick = {
                        onPokemonClick(pokemon)
                    }
                )
            }
        }
    }
}
