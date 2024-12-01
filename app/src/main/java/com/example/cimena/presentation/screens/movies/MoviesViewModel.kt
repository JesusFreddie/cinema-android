package com.example.cimena.presentation.screens.movies

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.cimena.R

import androidx.lifecycle.ViewModel

class MoviesViewModel : ViewModel() {
    private val _state = MutableStateFlow(MovieUIState())
    val state = _state.asStateFlow()

    private val dummyMovies = listOf(
        MovieUIState.Movie(
            title = "Arcane",
//            imagesRes = R.drawable.movie1,
            duration = "9h",
            genres = listOf("Action","Fantasy")
        ),
        MovieUIState.Movie(
            title = "Dune",
//            imagesRes = R.drawable.movie2,
            duration = "2h",
            genres = listOf("Action","Family")
        ),
        MovieUIState.Movie(
            title = "Dune 2",
//            imagesRes = R.drawable.movie3,
            duration = "3h",
            genres = listOf("Adventure","Fantasy")
        ),

        )
}