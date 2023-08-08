package com.example.altitudeangeltest.ui.forecasts

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.altitudeangeltest.data.models.Forecast

@Composable
fun DayItem(forecast:Forecast, onClick:() ->Unit){
    Column(modifier = Modifier
        .padding(6.dp)
        .fillMaxWidth()
        .border(2.dp, SolidColor(Color.Black), shape = RoundedCornerShape(10.dp))
        .clickable { onClick() }) {
//        1. Date
//        2. Condition text
//        3. Condition icon
        Row(modifier = Modifier.padding(6.dp)){
            Column{
                forecast.date?.let { Text(text = it) }
                forecast.dayCondition?.text?.let { Text(text = it) }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                val imageUrl = forecast.dayCondition?.icon
                val newImageUrl = if(imageUrl?.startsWith("http") != true){
                    "https:$imageUrl"
                }else{
                    imageUrl
                }
                AsyncImage(newImageUrl, contentDescription = "", modifier = Modifier
                    .height(40.dp)
                    .width(40.dp))
            }
        }


    }
}
