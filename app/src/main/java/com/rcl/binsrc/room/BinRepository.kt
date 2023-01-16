package com.rcl.binsrc.room

import kotlinx.coroutines.flow.Flow

class BinRepository(private val BinDao: BinDao) {
    val readAllData : Flow<List<Bin>> =  BinDao.getAll()

    suspend fun addBin(Bin: Bin) {
        BinDao.insert(Bin)
    }
}
