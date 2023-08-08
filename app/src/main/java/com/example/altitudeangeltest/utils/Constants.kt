package com.example.altitudeangeltest.utils

object Constants {
    const val CACHE_SIZE :Long= 5 * 1024 * 1024
    const val API_TIMEOUT :Long = 30
    const val API = "https://api.weatherapi.com/v1/"
    const val FORECAST = "forecast.json"
    const val FORECAST_URI = "forecastUri"
    const val FORECAST_CLIENT = "forecastClient"
    const val apiKey = "3d4276dd29c4430abad132627230708"

    // https://api.weatherapi.com/v1/forecast.json?key=3d4276dd29c4430abad132627230708&q=London&days=7
}
