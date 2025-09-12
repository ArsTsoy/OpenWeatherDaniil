package com.example.myapplication.di

import com.example.myapplication.data.model.GeocodeResponse
import com.example.myapplication.data.model.Location
import com.example.myapplication.data.repository.GeocodeRepository
import com.example.myapplication.ui.view.MainActivity
import com.example.myapplication.ui.viewmodel.GeocodeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class ModuleRepos (val repository : com.example.myapplication.di.ModuleRepos?){
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
