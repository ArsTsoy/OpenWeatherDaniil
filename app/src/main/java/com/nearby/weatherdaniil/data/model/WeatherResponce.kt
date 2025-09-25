package com.nearby.weatherdaniil.data.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WeatherResponce(
        val latitude: Double,
        val longitude: Double,
        @SerialName("hourly_units")
        val hourlyUnits: HourlyUnits,
        val hourly: HourlyData
    )

    @Serializable
    data class HourlyUnits(
        val time: String,
        @SerialName("temperature_2m")
        val temperature2m: String,
        @SerialName("relative_humidity_2m")
        val relativeHumidity2m: String,
        @SerialName("weather_code")
        val weatherCode: String,
        val rain: String
    )

    @Serializable
    data class HourlyData(
        val time: List<String>,
        @SerialName("temperature_2m")
        val temperature2m: List<Double>,
        @SerialName("relative_humidity_2m")
        val relativeHumidity2m: List<Double>,
        @SerialName("weather_code")
        val weatherCode: List<Int>,
        val rain: List<Double>
    )



