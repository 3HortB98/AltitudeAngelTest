package com.example.altitudeangeltest.ui.forecasts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ForecastScreen(
    forecastViewModel: ForecastViewModel = viewModel()
) {
    val viewState = forecastViewModel.viewState.observeAsState()
    val uiState = forecastViewModel.uiState.collectAsState()

Column {
    //todo remove test code
    Text(text = "Forecast screen")
    Button(onClick = {forecastViewModel.getData()}){
        Text(text = "CLick")
    }
    Text(text = viewState.value.toString())

    when(uiState.value){
        is ForecastUiState.Loading ->{}
        is ForecastUiState.Success ->{

            LazyColumn(modifier = Modifier.fillMaxSize()){
                val forecasts = (uiState.value as ForecastUiState.Success).forecasts
                items(forecasts?.forecasts.orEmpty()){forecast ->
                    DayItem(forecast)
                }
            }

        }
        is ForecastUiState.Error -> {
            Text(text = (uiState.value as ForecastUiState.Error).message)}
    }


}

}
