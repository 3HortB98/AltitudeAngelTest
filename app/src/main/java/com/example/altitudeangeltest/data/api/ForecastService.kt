package com.example.altitudeangeltest.data.api

import com.example.altitudeangeltest.data.models.dto.WeatherDTO
import com.example.altitudeangeltest.utils.Constants.FORECAST
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ForecastService {

    @Headers("Accept:application/json")
    @GET(FORECAST)
    suspend fun getForecast(
        @Query("key") apikey: String,
        @Query("q") query: String,
        @Query("days") days: Int
    ): Response<WeatherDTO>
}
