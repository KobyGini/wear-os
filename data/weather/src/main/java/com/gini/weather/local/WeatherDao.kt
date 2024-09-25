package com.gini.weather.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gini.weather.model.WeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weatherentity")
    fun getAll(): Flow<List<WeatherEntity>>

    @Insert
    fun insertAll(weather: List<WeatherEntity>)
}
