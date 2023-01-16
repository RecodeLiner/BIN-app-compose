package com.rcl.binsrc.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BinDao {
    @Query("SELECT * FROM bin_table")
    fun getAll(): Flow<List<Bin>>

    @Insert
    suspend fun insert(Bin: Bin)

    @Query("DELETE FROM bin_table")
    suspend fun deleteAll()
}