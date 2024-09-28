package com.example.cimena

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cimena.ui.theme.CimenaTheme
import androidx.navigation.compose.rememberNavController
import com.example.cimena.ui.theme.Black

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CimenaTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopAppBar(title = {
                            Text(
                                text = "Cinema",
                                modifier = Modifier.clickable {
                                    navController.navigate(Screen.Main.route)
                                }
                            ),
                        },
                        colors = TopAppBarDefaults.topAppBarColors(Black)
                        )
                    }
                    ) { innerPadding ->
                        Surface(modifier = Modifier.padding(innerPadding)) {

                        }
                    
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Bye $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CimenaTheme {
        Greeting("Android")
    }
}