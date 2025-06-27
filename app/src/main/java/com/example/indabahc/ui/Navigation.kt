package com.example.indabahc.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.indabahc.MainActivity
import com.example.indabahc.ui.Destinations.Diet
import com.example.indabahc.ui.Destinations.Medication
import com.example.indabahc.ui.Destinations.Pain
import com.example.indabahc.ui.home.HomeScreen


object Destinations{
    const val HomeScreen = "home"
    const val Diet = "diet"
    const val Medication = "medication"
    const val Pain = "pain"
}

@Composable
fun OnEntryNavigation(
    modifier: Modifier,
    navController: NavHostController = rememberNavController(),
    context: MainActivity
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.HomeScreen
    ) {

        composable(route = "home") {
            HomeScreen(
                modifier = Modifier,
                onDietCardClicked = {{navController.navigate(route = Diet)}},
                onMedicationCardClicked = {navController.navigate(route = Medication)},
                onPainCardClicked =  {navController.navigate(route = Pain)},
            )
        }

        composable(route = "diet") {


        }

        composable(route = "medication") {
            MedicationScreen(
                modifier = Modifier,
                onNavUp = {navController.navigateUp()}
            )

        }

    }
}

