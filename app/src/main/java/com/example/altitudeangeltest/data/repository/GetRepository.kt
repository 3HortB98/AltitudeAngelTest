package com.example.altitudeangeltest.data.repository

import com.example.altitudeangeltest.data.api.ForecastService
import com.example.altitudeangeltest.data.models.Forecasts
import javax.inject.Inject

interface GetRepository {
    suspend fun getForecast(): Result<Forecasts>
}

