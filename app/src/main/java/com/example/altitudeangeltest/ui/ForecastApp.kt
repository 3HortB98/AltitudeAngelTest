package com.example.altitudeangeltest.ui

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.altitudeangeltest.ui.dayDetails.DetailsScreen
import com.example.altitudeangeltest.ui.forecasts.ForecastScreen
import com.example.altitudeangeltest.ui.forecasts.ForecastViewModel

@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun ForecastApp() {
    val navController = rememberNavController()

    MaterialTheme {
        NavHost(navController,"weather"){
            navigation(startDestination = "forecast", route = "weather"){
                composable(route = "forecast"){
                    val weatherBackStackEntry = remember {
                        navController.getBackStackEntry("weather")
                    }
                    val forecastViewModel = hiltViewModel<ForecastViewModel>(weatherBackStackEntry)
                    ForecastScreen(forecastViewModel, onDayClick = {navController.navigate("details")})
                }
                composable(route = "details"){
                    val weatherBackStackEntry = remember {
                        navController.getBackStackEntry("weather")
                    }
                    val detailsViewModel = hiltViewModel<ForecastViewModel>(weatherBackStackEntry)
                    DetailsScreen(detailsViewModel)
                }
            }

        }
    }
}
