package com.gini.weather.usecase

import com.gini.weather.model.Weather
import com.gini.weather.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetWeeklyWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(): Flow<List<Weather>> {
        return repository.getWeeklyWeather().map {
            it.map { Weather(it.id) }
        }
    }
}