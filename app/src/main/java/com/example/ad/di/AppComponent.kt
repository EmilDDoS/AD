package com.example.ad.di

import androidx.lifecycle.ViewModel
import dagger.Component

@Component(modules = [
    ViewModelModule::class,
    DataModule::class,
    DomainModule::class,
    ApplicationModule::class
])
interface AppComponent {
    val mapModels: Map<Class<*>, ViewModel>
}