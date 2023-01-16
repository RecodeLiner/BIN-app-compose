package com.rcl.binsrc.room

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BinViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(BinViewModel::class.java)) {
            return BinViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}