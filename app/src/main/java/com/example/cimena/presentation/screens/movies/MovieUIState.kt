package com.example.cimena.presentation.screens.movies

data class MovieUIState(
    val movies: List<Movie> = emptyList()
) {
    data class Movie(
        val title: String = "",
        val imagesRes: Int = 0,
        val duration: String = "",
        val genres: List<String> = emptyList()
    )
}