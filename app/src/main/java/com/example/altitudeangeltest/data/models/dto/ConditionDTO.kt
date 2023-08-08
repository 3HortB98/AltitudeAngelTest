package com.example.altitudeangeltest.data.models.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class ConditionDTO(
    @Json(name = "text") val text: String? = null,
    @Json(name = "icon") val icon: String? = null,
    @Json(name = "code") val code: Int? = null
)
