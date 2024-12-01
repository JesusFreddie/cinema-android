package com.example.cimena.presentation.navigation

import RegisterScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.memorizeapp.presentation.navigation.Screen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Authentication.route
    ) {
        composable(route = Screen.Authentication.route) {
            RegisterScreen(navController = navController)
        }
    }
}