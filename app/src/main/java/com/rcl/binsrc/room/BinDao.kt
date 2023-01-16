package com.rcl.binsrc.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BinDao {
    @Query("SELECT * FROM bin_table")
    fun getAll(): LiveData<List<Bin>>

    @Insert
    suspend fun insert(Bin: Bin)

    @Query("DELETE FROM bin_table")
    suspend fun deleteAll()
}