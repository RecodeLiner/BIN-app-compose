package com.rcl.binsrc.retrofit

data class ApiModel(
    var bin: String,
    val bank: Bank,
    val brand: String?,
    val country: Country,
    val number: Number,
    val prepaid: Boolean?,
    val scheme: String,
    val type: String?
)