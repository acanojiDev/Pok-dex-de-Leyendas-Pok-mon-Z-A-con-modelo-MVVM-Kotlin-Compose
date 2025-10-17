package com.turingalan.pokemon.ui.routes

import kotlinx.serialization.Serializable

@Serializable
object PokemonListRoute

@Serializable
data class PokemonDetailRoute(
    val id:Int
)