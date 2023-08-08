package com.example.altitudeangeltest.ui.Forecasts

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ForecastScreen(
    forecastViewModel: ForecastViewModel = viewModel()
) {
    val viewState = forecastViewModel.viewState.observeAsState()
Column() {
    Text(text = "Forecast screen")
    Button(onClick = {forecastViewModel.getData()}){
        Text(text = "CLick")
    }
    Text(text = viewState.value.toString())
}

}
