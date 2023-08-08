package com.example.altitudeangeltest.ui.dayDetails

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp


@Composable
fun DetailsItem(title: String, data: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(6.dp)
            .wrapContentSize()
            .border(2.dp, SolidColor(Color.Black), shape = RoundedCornerShape(10.dp))
    ) {
        Column(modifier = Modifier.padding(6.dp)) {
            Text(text = title )
            Text(text = data)
        }

    }
}
