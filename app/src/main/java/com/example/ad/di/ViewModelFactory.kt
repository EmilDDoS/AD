package com.example.ad.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ad.app.App


class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = App.componentApp.mapModels[modelClass]
        return viewModel as T
    }
}