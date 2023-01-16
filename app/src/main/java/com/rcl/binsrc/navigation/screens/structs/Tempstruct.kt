package com.rcl.binsrc.navigation.screens.structs

import com.rcl.binsrc.retrofit.ApiModel
import com.rcl.binsrc.retrofit.Bank
import com.rcl.binsrc.retrofit.Country
import com.rcl.binsrc.retrofit.Number
import com.rcl.binsrc.room.Bin
import com.rcl.binsrc.room.BinViewModel

object Tempstruct {
    var mbinviewmodel: BinViewModel? = null
    var list = mutableListOf<Bin>()
    val temp2 = Bin(
        bin = "123456",
        scheme = "visa",
        type = "debit",
        bank_city = "Moscow",
        bank_name = "Sberbank",
        bank_url = "https://sberbank.ru",
        bank_phone = "+7 495 123 45 67",
        country_name = "Russia",
        country_emoji = "🇷🇺",
        country_latitude = "55.755826",
        country_longitude = "37.6173",
        country_currency = "RUB",
        prepaid = false,
        number_length = 16,
        number_luhn = true,
        country_alpha2 = "RU",
        country_numeric = "643",
        brand = "Visa",
        id = 0
    )
    val temp = ApiModel(
        bin = "12345678",
        scheme = "visa",
        type = "debit",
        bank = Bank(
            name = "JPMorgan Chase Bank, N.A.",
            url = "www.chase.com",
            phone = "+1-800-935-9935",
            city = "New York"
        ),
        country = Country(
            numeric = "840",
            alpha2 = "US",
            name = "United States of America",
            emoji = "🇺🇸",
            latitude = "38",
            longitude = "-97",
            currency = "USD",
        ),
        number = Number(
            length = 16,
            luhn = true
        ),
        brand = "Visa",
        prepaid = false
    )
}