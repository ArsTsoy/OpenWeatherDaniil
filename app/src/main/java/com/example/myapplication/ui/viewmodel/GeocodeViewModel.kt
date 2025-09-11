package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.Location
import com.example.myapplication.data.repository.GeocodeRepository

class GeocodeViewModel (private val repository: GeocodeRepository) : ViewModel() {

    private val _locations = MutableLiveData<Result<List<Location>>>()
    val locations: LiveData<Result<List<Location>>> = _locations

    fun search(name: String) = viewModelScope.launch {
        if (name.length < 2) {
            _locations.value = Result.success(emptyList())
            return@launch
        }
        _locations.value = Result.runCatching { repository.getLocations(name).getOrThrow() }
    }
}