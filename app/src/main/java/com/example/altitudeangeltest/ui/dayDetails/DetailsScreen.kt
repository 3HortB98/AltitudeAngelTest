package com.example.altitudeangeltest.ui.dayDetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.altitudeangeltest.ui.forecasts.DayItem
import com.example.altitudeangeltest.ui.forecasts.ForecastViewModel

@Composable
fun DetailsScreen( forecastViewModel: ForecastViewModel = viewModel()) {

    val dayDetails = forecastViewModel.dayForecastState.collectAsState()

    DayItem(dayDetails.value, onClick = {})
}
