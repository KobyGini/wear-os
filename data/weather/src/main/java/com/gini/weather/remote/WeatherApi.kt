package com.gini.weather.remote

import com.gini.weather.model.WeatherDto
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap


interface WeatherApi {

    @GET("forecast?")
    suspend fun getWeeklyWeather(@QueryMap params: Map<String, String>): WeatherResponse

//    locations = Herndon, VA, 20170
//    & aggregateHours=24
//    &unitGroup=us
//    &shortColumnNames=false
//    &contentType=csv
//    &key=YOURAPIKEY)
}

object WeatherBuilder {
    fun build(
        location: String,
        aggregateHours: String,
        unitGroup: String = "",
        shortColumnNames: String = "",
        contentType: String = ""
    ): Map<String, String> {
        return mapOf(
            "location" to location,
            "aggregateHours" to aggregateHours,
            "contentType" to "json"
        )
    }
}

enum class WeatherParams {
    Location, AggregateHours, UnitGroup, ShortColumnNames, ContentType, Key
}

data class WeatherResponse(
    val locations: WeatherLocation
)

data class WeatherLocation(
    @SerializedName("Herndon,VA,20170")
    val weatherCurrentLocation: WeatherCurrentLocation
)

data class WeatherCurrentLocation(
    val values: List<WeatherLocationValues>
)

data class WeatherLocationValues(
    val wdir: String,
    val uvindex: String
)