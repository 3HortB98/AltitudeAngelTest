package com.example.altitudeangeltest.data.models

class Forecast (
    val date: String?,
    val dateEpoch: Int?,
    val dayCondition: Condition?,
    val sunrise: String?,
    val sunset: String?,
    val hour: List<Hour>
    //val astro: AstroDTO? = AstroDTO(),

)
