package com.example.altitudeangeltest.data.repository

import com.example.altitudeangeltest.data.api.ApiHelper
import javax.inject.Inject

class ForecastRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getForecast()= apiHelper.getForecast()
}
