package com.example.altitudeangeltest.data.mapper

import com.example.altitudeangeltest.data.models.Condition
import com.example.altitudeangeltest.data.models.Forecast
import com.example.altitudeangeltest.data.models.Forecasts
import com.example.altitudeangeltest.data.models.dto.WeatherDTO
import javax.inject.Inject

class GetForecastMapper @Inject constructor(
    private val getConditionMapper: GetConditionMapper
) {

    fun mapForecast(weatherDTO: WeatherDTO): Result<Forecasts>{

        return Result.success(
            Forecasts(
                forecasts = weatherDTO.forecast?.forecastDay?.map {
                    Forecast(
                        date = it.date,
                        dateEpoch = it.dateEpoch,
                        dayCondition = getConditionMapper.fromDTO(it.day?.condition)
                    )
                } as ArrayList<Forecast>
            )
        )
    }
}
