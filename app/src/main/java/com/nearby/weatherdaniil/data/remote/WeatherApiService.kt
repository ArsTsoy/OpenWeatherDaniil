package com.nearby.weatherdaniil.data.remote

import com.nearby.weatherdaniil.data.model.WeatherResponce
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("forecast")
    suspend fun getForecast(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") hourly: String = "temperature_2m,relative_humidity_2m,weather_code,rain",
        @Query("wind_speed_unit") windSpeedUnit: String = "ms"

    ): WeatherResponce
}
