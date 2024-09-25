package com.gini.weather.repository

import android.util.Log
import com.gini.util.WeatherMapper
import com.gini.weather.local.WeatherDao
import com.gini.weather.model.WeatherDto
import com.gini.weather.model.WeatherEntity
import com.gini.weather.remote.WeatherApi
import com.gini.weather.remote.WeatherBuilder
import kotlinx.coroutines.flow.Flow
import java.lang.Exception
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi,
    private val weatherDao: WeatherDao
) {

    suspend fun getWeeklyWeather(): Flow<List<WeatherEntity>> {
        val weatherDtoList = weatherApi.getWeeklyWeather(WeatherBuilder.build("Herndon,VA,20170", "24"))
        val weatherEntityList = WeatherMapper.mapWeatherDtoToEntity(weatherDtoList.locations.weatherCurrentLocation.values)
        weatherDao.insertAll(weatherEntityList)
        return weatherDao.getAll()
    }
}