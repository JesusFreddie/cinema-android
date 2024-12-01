package com.example.memorizeapp.presentation.navigation

import com.example.cimena.R

sealed class Screen(
    val route: String,
    val title: String,
//    val icon: Int
) {
    object Authentication : Screen("authentication", "Регистрация")
    object Movies : Screen("movies", "Фильмы")
}