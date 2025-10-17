package com.turingalan.pokemon.ui.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.turingalan.pokemon.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//viewmodel casi al 90% va a tener dos atributos
@HiltViewModel //recuperarlo desde la vista
class PokemonListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle, //guarda estado si se destruye se sigue manteniendo,este siempre es necesario
    private val repository: PokemonRepository //se coge la interfaz para hacer uso de polimorfismo
): ViewModel() {

}