package com.example.altitudeangeltest.data.mapper

import com.example.altitudeangeltest.data.models.Condition
import com.example.altitudeangeltest.data.models.Forecast
import com.example.altitudeangeltest.data.models.Forecasts
import com.example.altitudeangeltest.data.models.Hour
import com.example.altitudeangeltest.data.models.dto.WeatherDTO
import javax.inject.Inject

class GetForecastMapper @Inject constructor(
    private val getConditionMapper: GetConditionMapper,
    private val getHourMapper: GetHourMapper
) {

    fun mapForecast(weatherDTO: WeatherDTO): Result<Forecasts> {

        return Result.success(
            Forecasts(
                forecasts = weatherDTO.forecast?.forecastDay?.map { it ->
                    it.hour.map {getHourMapper.fromDTO(it)}.let { hours ->
                        Forecast(
                            date = it.date,
                            dateEpoch = it.dateEpoch,
                            dayCondition = getConditionMapper.fromDTO(it.day?.condition),
                            sunrise = it.astro?.sunrise,
                            sunset = it.astro?.sunset,
                            hour = hours
                        )
                    }
                } as ArrayList<Forecast>
            )
        )
    }
}
