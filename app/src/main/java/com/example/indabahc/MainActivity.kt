package com.example.indabahc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.indabahc.ui.OnEntryNavigation
import com.example.indabahc.ui.home.Home
import com.example.indabahc.ui.home.HomeScreen
import com.example.indabahc.ui.loginScreen.SignInScreen
import com.example.indabahc.ui.theme.IndabaHCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController: NavHostController = rememberNavController()

            IndabaHCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OnEntryNavigation(
                        Modifier.padding(innerPadding),
                        context = this
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
