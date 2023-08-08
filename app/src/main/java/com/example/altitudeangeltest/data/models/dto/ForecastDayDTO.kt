package com.example.altitudeangeltest.data.models.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastDayDTO(
    @Json(name = "date")val date: String? = null,
    @Json(name= "date_epoch" ) val dateEpoch: Int? = null,
    @Json(name = "day")val day: DayDTO?,
    @Json(name = "astro")val astro: AstroDTO?,
    @Json(name = "hour")val hour : List<HourDTO> = emptyList()
)
