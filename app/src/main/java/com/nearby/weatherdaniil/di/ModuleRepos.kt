package com.nearby.weatherdaniil.di

import com.nearby.weatherdaniil.data.model.GeocodeResponse
import com.nearby.weatherdaniil.data.model.Location
import com.nearby.weatherdaniil.data.repository.GeocodeRepository
import com.nearby.weatherdaniil.ui.view.MainActivity
import com.nearby.weatherdaniil.ui.viewmodel.GeocodeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class ModuleRepos (val repository : com.nearby.weatherdaniil.di.ModuleRepos?){
    val myModule = module {
        singleOf(::ModuleRepos)
        singleOf(::GeocodeRepository)
        singleOf(::GeocodeResponse)
        singleOf(::Location)
        singleOf(::MainActivity)
        singleOf(::GeocodeViewModel)}

    companion object {
        val myModule: Module = TODO()
    }

}