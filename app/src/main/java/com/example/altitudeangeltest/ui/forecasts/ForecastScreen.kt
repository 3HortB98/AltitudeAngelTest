package com.example.altitudeangeltest.ui.forecasts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ForecastScreen(
    forecastViewModel: ForecastViewModel = viewModel(),
    onDayClick:()-> Unit
) {
    val viewState = forecastViewModel.viewState.observeAsState()
    val uiState = forecastViewModel.uiState.collectAsState()

Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally) {
    //todo remove test code
    Text(text = "Your 7 day forecast", fontSize = 20.sp)
    Button(onClick = {forecastViewModel.getData()}){
        Text(text = "Refresh")
    }

    when(uiState.value){
        is ForecastUiState.Loading ->{
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }
        is ForecastUiState.Success ->{

            LazyColumn(modifier = Modifier.fillMaxSize()){
                val forecasts = (uiState.value as ForecastUiState.Success).forecasts
                items(forecasts?.forecasts.orEmpty()){forecast ->
                    DayItem(forecast, onClick = {
                        forecastViewModel.forecastDaySelected(forecast)
                        onDayClick()
                    })
                }
            }

        }
        is ForecastUiState.Error -> {
            Text(text = (uiState.value as ForecastUiState.Error).message)}
    }


}

}
