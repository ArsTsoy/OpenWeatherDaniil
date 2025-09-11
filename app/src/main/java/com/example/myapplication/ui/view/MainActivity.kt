package com.example.myapplication.ui.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.remote.GeocodingApiService
import com.example.myapplication.data.repository.GeocodeRepository
import com.example.myapplication.ui.viewmodel.GeocodeViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<GeocodeViewModel> {
        // Если используете Hilt/Koin — используйте их фабрики
        ViewModelProvider.Factory { GeocodeViewModel(GeocodeRepository(GeocodingApiService.create())) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mutableListOf())
        binding.listView.adapter = adapter

        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            viewModel.search(query)
        }

        viewModel.locations.observe(this) { result ->
            result.onSuccess { list ->
                adapter.clear()
                adapter.addAll(list.map { "${it.name}, ${it.country} (${it.latitude}, ${it.longitude})" })
            }.onFailure {
                Toast.makeText(this, "Error: ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}