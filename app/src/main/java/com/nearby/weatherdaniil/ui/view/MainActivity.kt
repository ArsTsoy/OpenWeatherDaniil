package com.nearby.weatherdaniil.ui.view
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nearby.weatherdaniil.data.remote.GeocodingApiService
import com.nearby.weatherdaniil.data.repository.GeocodeRepository
import com.nearby.weatherdaniil.databinding.MainActivityBinding
import com.nearby.weatherdaniil.ui.viewmodel.GeocodeViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: GeocodeViewModel = GeocodeViewModel(
        GeocodeRepository(GeocodingApiService)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainActivityBinding.inflate(layoutInflater)
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

