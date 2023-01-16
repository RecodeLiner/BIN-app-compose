package com.rcl.binsrc.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class BinViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: Flow<List<Bin>>
    private val repository: BinRepository

    init {
        val binDao = BinDataBase.getInstance(application).BinDao()
        repository = BinRepository(binDao)
        readAllData = repository.readAllData
    }

    fun addBin(Bin: Bin) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBin(Bin)
        }
    }
}


