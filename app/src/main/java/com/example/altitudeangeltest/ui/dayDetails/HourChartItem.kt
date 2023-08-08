package com.example.altitudeangeltest.ui.dayDetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.altitudeangeltest.data.models.Hour

@Composable
fun HourChartItem(hour: List<Hour>, date:String){

    LazyRow(modifier = Modifier.wrapContentHeight().padding(6.dp)){
        items(hour){hour ->
            Column {
                Row() {
                    Divider(
                        color = Color.Red,
                        modifier = Modifier
                            .height(300.dp)
                            .width(1.dp)
                    )
                    Column {
                        DetailsItem(title = "Temp.C", data = hour.tempC.toString())
                        DetailsItem(title = "UV", data = hour.uv.toString())
                        DetailsItem(title = "Gust.mph", data = hour.gustMph.toString())
                        DetailsItem(title = "Humidity", data = hour.humidity.toString())
                        hour.time?.let {
                            Text(it.removePrefix(date))
                        }
                    }
                }
            }

        }
    }
}
