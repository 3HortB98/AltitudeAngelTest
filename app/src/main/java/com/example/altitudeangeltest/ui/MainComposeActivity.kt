package com.example.altitudeangeltest.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.altitudeangeltest.ui.Forecasts.ForecastApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainComposeActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForecastApp()
        }
    }
}