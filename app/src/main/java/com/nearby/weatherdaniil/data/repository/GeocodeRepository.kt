package com.nearby.weatherdaniil.data.repository

import com.nearby.weatherdaniil.data.model.Location
import com.nearby.weatherdaniil.data.remote.GeocodingApiService

class GeocodeRepository(private val api: GeocodingApiService) {
    suspend fun getLocations(name: String): Result<List<Location>> {
        return try {
            val response = api.searchLocations(name)
            val locations = response.results ?: emptyList()
            Result.success(locations)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}