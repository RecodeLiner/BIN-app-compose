package com.rcl.binsrc.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Bin::class)], version = 1, exportSchema = false)
abstract class BinDataBase : RoomDatabase() {

    abstract fun BinDao(): BinDao

    companion object {
        @Volatile
        private var INSTANCE: BinDataBase? = null

        fun getInstance(context: Context): BinDataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BinDataBase::class.java,
                        "bin_table"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}