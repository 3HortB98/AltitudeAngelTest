package com.example.altitudeangeltest.data.api

import com.example.altitudeangeltest.data.models.dto.WeatherDTO
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ForecastService) :ApiHelper {

    override suspend fun getForecast(): Response<WeatherDTO> =  apiService.getForecast("3d4276dd29c4430abad132627230708","London", 7)

}
