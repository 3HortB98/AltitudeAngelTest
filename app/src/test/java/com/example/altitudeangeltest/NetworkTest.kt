package com.example.altitudeangeltest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.Observer
import com.example.altitudeangeltest.data.NetworkClient
import com.example.altitudeangeltest.data.models.Forecast
import com.example.altitudeangeltest.data.models.Forecasts
import com.example.altitudeangeltest.ui.forecasts.ForecastUiState
import com.example.altitudeangeltest.ui.forecasts.ForecastViewModel
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

import org.junit.After
import org.junit.Assert.assertEquals

import org.junit.Before
import org.junit.Rule
import org.junit.Test


class NetworkTest {
    private val mockGetForecastRepository:NetworkClient = mockk(relaxed = true)
    private lateinit var vm: ForecastViewModel
    private val viewStateObserver: Observer< Result<Forecasts>> = mockk(relaxed = true)
    private lateinit var mockForecast: Forecasts
    private val expectedResponseData = Forecasts(emptyList())
    private val dispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val mockkRule = MockKRule(this)

    @ExperimentalCoroutinesApi
    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        mockForecast = expectedResponseData
        coEvery { mockGetForecastRepository.getForecast() }returns Result.success(mockForecast)
        vm = ForecastViewModel(mockGetForecastRepository, TestDispatcherProvider())

    }

    @After
    fun close() {
        Dispatchers.resetMain()
    }


    @Test
    fun `test for getting data and return is successful`() = runTest{

        val value = vm.uiState.value
        backgroundScope.launch{
            vm.getData()
        }
        assertEquals(ForecastUiState.Success(expectedResponseData),value)



    }

}
