package com.example.memorizeapp.presentation.navigation

sealed class Screen(
    val route: String
) {
    object Main : Screen("main")
    object AddStack: Screen("addstack")
    object AddCard: Screen("addcard")
    object Stacks: Screen("stacks")
    object Question : Screen("questions")
}