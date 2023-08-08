package com.example.altitudeangeltest.data.mapper

import com.example.altitudeangeltest.data.models.Hour
import com.example.altitudeangeltest.data.models.dto.HourDTO
import javax.inject.Inject

class GetHourMapper@Inject constructor(){

    fun fromDTO(hourDTO: HourDTO): Hour{

        return Hour(
                time = hourDTO.time,
        humidity = hourDTO.humidity,
        uv = hourDTO.uv,
        gustMph = hourDTO.gustMph,
        gustKph = hourDTO.gustKph,
        tempC = hourDTO.tempC,
        tempF = hourDTO.tempF

        )

    }
}
