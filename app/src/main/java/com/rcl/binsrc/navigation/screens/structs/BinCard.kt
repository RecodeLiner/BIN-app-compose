package com.rcl.binsrc.navigation.screens.structs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.rcl.binsrc.retrofit.ApiModel

class BinCard {
    @Composable
    fun Card(apiModel: ApiModel) {
        Box {
            LazyColumn(content = {
                item {
                    Text(text = "Number:")
                    Text(text = "Length: ${apiModel.number.length}")
                    Text(text = "Is Luhn algorithm: ${apiModel.number.luhn}")
                    Text(text = "Payment system: ${apiModel.scheme}")
                    Text(text = "Type: ${apiModel.type}")
                    Text(text = "Phone number: ${apiModel.bank.phone}")
                }
            })
        }
    }
}