package com.example.altitudeangeltest.ui.Forecasts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.altitudeangeltest.data.NetworkClient
import com.example.altitudeangeltest.data.repository.ForecastRepository
import com.example.altitudeangeltest.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
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

    init {
        getData()
    }


    fun getData(){
        _viewState.value = "data launch"
        viewModelScope.launch {
            Timber.d("test forecast ")
            val result = networkClient.getForecast()
            if(result.isSuccess){
                val resultData = result.getOrNull()
                _viewState.value = "got data"
            }else{
                _viewState.value = result.toString()

            }
        }
    }
}
