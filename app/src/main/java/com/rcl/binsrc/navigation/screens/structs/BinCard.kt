package com.rcl.binsrc.navigation.screens.structs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.rcl.binsrc.retrofit.ApiModel
import com.rcl.binsrc.retrofit.Bank
import com.rcl.binsrc.retrofit.Country
import com.rcl.binsrc.retrofit.Number

class BinCard {
    var intapimod = mutableStateOf(ApiModel(Bank("", "", "",""), "", Country("", "", "", 0, 0, "", ""), Number(0, false), false, "", ""))

    fun setApiModel(apiModel: ApiModel) {
        intapimod.value = apiModel
    }

    @Composable
    fun Card() {
        Box {
            LazyColumn(content = {
                item {
                    Text(text = "Number:")
                    Text(text = "Length: ${intapimod.value.number.length}")
                    Text(text = "Is Luhn algorithm: ${intapimod.value.number.luhn}")
                    Text(text = "Payment system: ${intapimod.value.scheme}")
                    Text(text = "Type: ${intapimod.value.type}")
                    Text(text = "Phone number: ${intapimod.value.bank.phone}")
                }
            })
        }
    }
}