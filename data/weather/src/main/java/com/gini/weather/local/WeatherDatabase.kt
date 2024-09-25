package com.gini.weather.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gini.weather.model.WeatherEntity

@Database(entities = [WeatherEntity::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}