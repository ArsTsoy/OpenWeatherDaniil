package com.nearby.weatherdaniil.data.repository

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nearby.weatherdaniil.data.remote.WeatherApiService
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class WeatherRepository {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.open-meteo.com/v1/")
        .addConverterFactory(
            kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            }
                .let { json ->
                    kotlinx.serialization.json.Json
                }
                .let { json ->
                    kotlinx.serialization.json.Json.asConverterFactory("application/json".toMediaType())
                }
        )
        .build()
    val api = retrofit.create(WeatherApiService::class.java)
}