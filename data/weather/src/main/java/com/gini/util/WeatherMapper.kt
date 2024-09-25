package com.gini.util

import com.gini.weather.model.WeatherEntity
import com.gini.weather.remote.WeatherLocationValues
import java.util.UUID

object WeatherMapper {

    fun mapWeatherDtoToEntity(list: List<WeatherLocationValues>): List<WeatherEntity> {
        return list.map { weatherDto ->
            WeatherEntity(
                id = UUID.randomUUID().toString(),
                wdir = weatherDto.uvindex
            )
        }
    }
}