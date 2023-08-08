package com.example.altitudeangeltest.data.models.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastDTO(
    @Json(name = "forecastday") val forecastDay: List<ForecastDayDTO> = emptyList()
)
