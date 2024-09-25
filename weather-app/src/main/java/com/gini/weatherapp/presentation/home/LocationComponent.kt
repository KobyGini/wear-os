package com.gini.weatherapp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.gini.weatherapp.model.DailyWeather

@Composable
fun LocationComponent(dailyWeather: DailyWeather) {
    Column {
        Text(text = dailyWeather.id)
    }
}