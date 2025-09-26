package com.nearby.weatherdaniil.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nearby.weatherdaniil.data.model.WeatherResponce
import com.nearby.weatherdaniil.data.remote.WeatherApiService
import kotlinx.coroutines.launch

class WeatherViewModel (private val api: WeatherApiService) : ViewModel() {
    val forecastLiveData = MutableLiveData<WeatherResponce>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchForecastFor(lat: Double, lon: Double) {
        viewModelScope.launch {
            try {
                val resp = api.getForecast(lat, lon)
                forecastLiveData.value = resp
            } catch (e: Exception) {
                errorLiveData.value = e.message
            }
        }
    }
}