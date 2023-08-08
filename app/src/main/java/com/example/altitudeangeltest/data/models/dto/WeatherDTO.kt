package com.example.altitudeangeltest.data.models.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherDTO(
   @Json(name="location") val location: LocationDTO?,
    @Json(name = "current") val current: CurrentDTO?,
    @Json(name = "forecast") val forecast: ForecastDTO?
)
