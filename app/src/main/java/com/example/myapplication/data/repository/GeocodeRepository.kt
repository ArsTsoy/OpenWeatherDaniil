package com.example.myapplication.data.repository

import com.example.myapplication.data.model.Location
import com.example.myapplication.data.remote.GeocodingApiService

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