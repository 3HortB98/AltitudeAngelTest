package com.example.altitudeangeltest.ui.forecasts

import com.example.altitudeangeltest.data.models.Forecasts

sealed class ForecastUiState {
    object Loading: ForecastUiState()
    data class Success(val forecasts: Forecasts?): ForecastUiState()
    data class Error(val message: String): ForecastUiState()


}
