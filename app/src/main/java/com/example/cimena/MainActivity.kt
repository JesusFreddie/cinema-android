package com.example.cimena

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cimena.ui.theme.CimenaTheme

import androidx.navigation.compose.rememberNavController
import com.example.cimena.presentation.navigation.AppNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CimenaTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
            }
        }
    }
}