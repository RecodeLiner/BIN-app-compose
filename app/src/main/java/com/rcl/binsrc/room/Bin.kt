package com.rcl.binsrc.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rcl.binsrc.retrofit.ApiModel

@Entity(tableName = "bin_table")
data class Bin(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val bin: String,
    val apiModel: ApiModel
)
