package com.example.altitudeangeltest.ui.forecasts

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.example.altitudeangeltest.data.models.Forecast

@Composable
fun DayItem(forecast:Forecast){
    Column() {
//        1. Date
//        2. Condition text
//        3. Condition icon
        forecast.date?.let { Text(text = it) }
        forecast.dayCondition?.text?.let { Text(text = it) }

        val imageUrl = forecast.dayCondition?.icon
        val newImageUrl = if(imageUrl?.startsWith("http") != true){
            "https:$imageUrl"
        }else{
            imageUrl
        }
        AsyncImage(newImageUrl, contentDescription = "")
    }
}
