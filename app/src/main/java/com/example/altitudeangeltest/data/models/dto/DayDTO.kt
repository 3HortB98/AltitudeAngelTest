package com.example.altitudeangeltest.data.models.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DayDTO(
    @Json(name = "maxtemp_c") val maxtempC: Double? = null,
    @Json(name = "maxtemp_f") val maxtempF: Double? = null,
    @Json(name = "mintemp_c") val mintempC: Double? = null,
    @Json(name = "mintemp_f") val mintempF: Double? = null,
    @Json(name = "avgtemp_c") val avgtempC: Double? = null,
    @Json(name = "avgtemp_f") val avgtempF: Double? = null,
    @Json(name = "maxwind_mph") val maxwindMph: Double? = null,
    @Json(name = "maxwind_kph") val maxwindKph: Double? = null,
    @Json(name = "totalprecip_mm") val totalprecipMm: Double? = null,
    @Json(name = "totalprecip_in") val totalprecipIn: Double? = null,
    @Json(name = "totalsnow_cm") val totalsnowCm: Double? = null,
    @Json(name = "avgvis_km") val avgvisKm: Double? = null,
    @Json(name = "avgvis_miles") val avgvisMiles: Double? = null,
    @Json(name = "avghumidity") val avghumidity: Double? = null,
    @Json(name = "daily_will_it_rain") val dailyWillItRain: Int? = null,
    @Json(name = "daily_chance_of_rain") val dailyChanceOfRain: Int? = null,
    @Json(name = "daily_will_it_snow") val dailyWillItSnow: Int? = null,
    @Json(name = "daily_chance_of_snow") val dailyChanceOfSnow: Int? = null,
    @Json(name = "condition")val condition: ConditionDTO?,
    @Json(name = "uv")val uv: Double? = null

)
