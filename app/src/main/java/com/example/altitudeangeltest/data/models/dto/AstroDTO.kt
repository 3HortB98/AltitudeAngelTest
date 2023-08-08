package com.example.altitudeangeltest.data.models.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class AstroDTO(
    @Json(name = "sunrise")val sunrise: String? = null,
    @Json(name = "sunset")val sunset: String? = null,
    @Json(name = "moonrise")val moonrise: String? = null,
    @Json(name = "moonset")val moonset: String? = null,
    @Json(name = "moon_phase") val moonPhase: String? = null,
    @Json(name = "moon_illumination") val moonIllumination: String? = null,
    @Json(name = "is_moon_up") val isMoonUp: Int? = null,
    @Json(name = "is_sun_up") val isSunUp: Int? = null
)
