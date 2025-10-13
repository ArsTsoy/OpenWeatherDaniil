package com.nearby.weatherdaniil.data.repository

import com.nearby.weatherdaniil.data.model.Location
import com.nearby.weatherdaniil.data.remote.GeocodingApiService

class GeocodeRepository(private val api: GeocodingApiService) {
    suspend fun getLocations(name: String): Result<List<Location>> {
        return runCatching {
            val response = api.searchLocations(name)
            response.results ?: emptyList()
        }
    }
}


