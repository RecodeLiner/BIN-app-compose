package com.rcl.binsrc.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_object")
data class Bin(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "bin") val bin: String,
    @ColumnInfo(name = "brand") val brand: String?,
    @ColumnInfo(name = "prepaid") val prepaid: Boolean?,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "scheme") val scheme: String?,
    @ColumnInfo(name = "bank_name") val bank_name: String?,
    @ColumnInfo(name = "bank_city") val bank_city: String?,
    @ColumnInfo(name = "bank_phone") val bank_phone: String?,
    @ColumnInfo(name = "bank_url") val bank_url: String?,
    @ColumnInfo(name = "country_name") val country_name: String?,
    @ColumnInfo(name = "country_alpha2") val country_alpha2: String,
    @ColumnInfo(name = "country_currency") val country_currency: String,
    @ColumnInfo(name = "country_emoji") val country_emoji: String,
    @ColumnInfo(name = "country_latitude") val country_latitude: String,
    @ColumnInfo(name = "country_longitude") val country_longitude: String,
    @ColumnInfo(name = "country_numeric") val country_numeric: String,
    @ColumnInfo(name = "number_length") val number_length: Int?,
    @ColumnInfo(name = "number_luhn") val number_luhn: Boolean?
)
