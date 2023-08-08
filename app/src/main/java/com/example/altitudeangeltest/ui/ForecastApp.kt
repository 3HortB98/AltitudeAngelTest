package com.example.altitudeangeltest.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.altitudeangeltest.ui.forecasts.ForecastScreen
import com.example.altitudeangeltest.ui.forecasts.ForecastViewModel

@Composable
fun ForecastApp() {
    val navController = rememberNavController()

    MaterialTheme {
        NavHost(navController,"forecasts"){
            composable(route = "forecasts"){
                val forecastViewModel = hiltViewModel<ForecastViewModel>()
                ForecastScreen(forecastViewModel)
            }
        }
    }
}
