package com.rcl.binsrc.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rcl.binsrc.retrofit.ApiModel

@Dao
interface BinDao {
    @Query("SELECT * FROM bin_table")
    fun all(): LiveData<List<Bin>>

    @Insert
    suspend fun insert(bin: String, apiModel: ApiModel)
}