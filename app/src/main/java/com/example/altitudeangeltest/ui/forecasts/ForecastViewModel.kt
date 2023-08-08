package com.example.altitudeangeltest.ui.forecasts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.altitudeangeltest.data.NetworkClient
import com.example.altitudeangeltest.data.models.Forecast
import com.example.altitudeangeltest.data.models.Forecasts
import com.example.altitudeangeltest.utils.DispatcherProvider
import com.example.altitudeangeltest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val networkClient: NetworkClient,
    private val dispatcherProvider: DispatcherProvider
):ViewModel() {

    private val _viewState = MutableLiveData("start")
    val viewState: LiveData<String> = _viewState

    private val _uiState = MutableStateFlow<ForecastUiState>(ForecastUiState.Loading)
    val uiState: StateFlow<ForecastUiState> = _uiState

    private val _dayForecastState = MutableStateFlow<Forecast>(Forecast("",0,null,"","",
        emptyList()
    ))
    val dayForecastState: StateFlow<Forecast> = _dayForecastState

    init {
        getData()
    }


    fun getData(){
        Resource.loading("")
        _viewState.value = "data launch"
        viewModelScope.launch {
            val result = networkClient.getForecast()
            if(result.isSuccess){
                val resultData = result.getOrNull()
                _uiState.value = ForecastUiState.Success(resultData)
                Resource.success(resultData)
                _viewState.value = "got data"
            }else{
                _uiState.value = ForecastUiState.Error(result.toString())
                Resource.error("Error getting data",result.toString())
                _viewState.value = result.toString()

            }
        }
    }

    fun forecastDaySelected(forecast: Forecast){
        _dayForecastState.value = forecast
    }
}
