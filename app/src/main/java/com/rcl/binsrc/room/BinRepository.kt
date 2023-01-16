package com.rcl.binsrc.room

import androidx.lifecycle.LiveData

class BinRepository(private val BinDao: BinDao) {
    val readAllData : LiveData<List<Bin>> =  BinDao.getAll()

    suspend fun addBin(Bin: Bin) {
        BinDao.insert(Bin)
    }
}
