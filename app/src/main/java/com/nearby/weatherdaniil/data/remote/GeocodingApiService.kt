package com.nearby.weatherdaniil.data.remote

import com.nearby.weatherdaniil.data.model.GeocodeResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApiService {
    @GET("search")
    suspend fun searchLocations(
        @Query("name") name: String,
        @Query("count") count: Int = 10,
        @Query("language") language: String = "en"
    ): GeocodeResponse

    fun getLocations(name: String)

    companion object : GeocodingApiService {
        fun create(): GeocodingApiService {
            val retrofit = Retrofit.Builder().baseUrl("https://geocoding-api.open-meteo.com/v1/")

                .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit.create(GeocodingApiService::class.java)
        }

        override suspend fun searchLocations(
            name: String, count: Int, language: String
        ): GeocodeResponse {
            return create().searchLocations(name, count, language)
        }

        override fun getLocations(name: String) {
        }
    }
}
val weatherRetrofit = Retrofit.Builder().baseUrl("https://geocoding-api.open-meteo.com/v1/")

