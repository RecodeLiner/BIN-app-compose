package com.rcl.binsrc.navigation.screens.structs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.rcl.binsrc.retrofit.ApiModel

class BinCard {
    @Composable
    fun Card(apiModel: ApiModel, modifier: Modifier) {
        Box (modifier = modifier) {
            Column(content = {
                Text(text = "Main info:", color = Color.Red)
                Box{
                    LazyColumn(content = {
                        item{
                            Text(text = "  Brand: ${apiModel.brand}")
                            Text(text = "  Scheme: ${apiModel.scheme}")
                            Text(text = "  Type: ${apiModel.type}")
                            Text(text = "  Prepaid: ${apiModel.prepaid}")
                        }
                    })
                }
                Text(text = "Bank:", color = Color.Red)
                Box{
                    LazyColumn(content = {
                        item {
                            Text(text = "  Name: ${apiModel.bank.name}")
                            Text(text = "  URL: ${apiModel.bank.url}")
                            Text(text = "  City: ${apiModel.bank.city}")
                            Text(text = "  Phone: ${apiModel.bank.phone}")
                        }
                    })
                }
                Text(text = "Country:", color = Color.Red)
                Box{
                    LazyColumn(content = {
                        item {
                            Text(text = "  Name: ${apiModel.country.name}")
                            Text(text = "  Alpha2: ${apiModel.country.alpha2}")
                            Text(text = "  Numeric: ${apiModel.country.numeric}")
                            Text(text = "  Emoji: ${apiModel.country.emoji}")
                            Text(text = "  Currency: ${apiModel.country.currency}")
                            Text(text = "  Latitude: ${apiModel.country.latitude}")
                            Text(text = "  Longitude: ${apiModel.country.longitude}")
                        }
                    })
                }
                Text(text = "Number:", color = Color.Red)
                Box{
                    LazyColumn(content = {
                        item {
                            Text(text = "  Length: ${apiModel.number.length}")
                            Text(text = "  Luhn: ${apiModel.number.luhn}")
                        }
                    })
                }
            })
        }
    }
}