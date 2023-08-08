package com.example.altitudeangeltest.data

import android.util.Log
import com.example.altitudeangeltest.data.api.ForecastService
import com.example.altitudeangeltest.data.mapper.GetForecastMapper
import com.example.altitudeangeltest.data.models.Forecasts
import com.example.altitudeangeltest.data.models.dto.WeatherDTO
import com.example.altitudeangeltest.data.repository.GetRepository
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class NetworkClient @Inject constructor(
    val apiService: ForecastService,
    val forecastMapper: GetForecastMapper
) : GetRepository {

    override suspend fun getForecast(): Result<Forecasts> {
        return try {
            val response = apiService.getForecast("3d4276dd29c4430abad132627230708","London", 7)
            Timber.d(response.message())
            if (response.isSuccessful && response.body() != null){
               return  forecastMapper.mapForecast(requireNotNull(response.body()))
            }else {
                Timber.tag("failed").e(response.message())
                Result.failure(Exception("Network Error"))
            }
        } catch(exceptions: Exception) {
           return Result.failure(exceptions)

        }
    }

}
