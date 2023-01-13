package com.rcl.binsrc.room

import androidx.lifecycle.LiveData
import com.rcl.binsrc.retrofit.ApiModel

class BinRepository(private val BinDao: BinDao) {
    val readAllData : LiveData<List<Bin>> =  BinDao.all()

    suspend fun addBin(apiModel: ApiModel, bin: String) {
        BinDao.insert(bin, apiModel)
    }
}
