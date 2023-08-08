package com.example.altitudeangeltest.ui.dayDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.altitudeangeltest.ui.forecasts.DayItem
import com.example.altitudeangeltest.ui.forecasts.ForecastViewModel

@Composable
fun DetailsScreen( forecastViewModel: ForecastViewModel = viewModel()) {

    val dayDetails = forecastViewModel.dayForecastState.collectAsState().value

    Column() {
        DayItem(dayDetails, onClick = {})
        Row() {
            dayDetails.sunrise?.let { DetailsItem(title = "Sunrise", data = it) }
            dayDetails.sunset?.let { DetailsItem(title = "Sunset", data = it) }
        }

        dayDetails.date?.let { HourChartItem(hour = dayDetails.hour, date = it) }

        Text(text = "Time throughout day ->")
    }
}
