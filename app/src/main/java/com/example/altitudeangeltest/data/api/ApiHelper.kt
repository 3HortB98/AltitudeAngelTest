package com.example.altitudeangeltest.data.api

import com.example.altitudeangeltest.data.models.dto.WeatherDTO
import retrofit2.Response

interface ApiHelper {

    suspend fun getForecast(): Response<WeatherDTO>
}
