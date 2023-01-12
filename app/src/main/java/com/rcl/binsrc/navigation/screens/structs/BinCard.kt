package com.rcl.binsrc.navigation.screens.structs

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.rcl.binsrc.retrofit.ApiModel


class BinCard {
    @Composable
    fun Card(apiModel: ApiModel, modifier: Modifier) {
        if (!apiModel.bank.url.contains("https://") && !apiModel.bank.url.contains("http://")) {
            apiModel.bank.url = "https://" + apiModel.bank.url
        }
        val linkintent = Intent(Intent.ACTION_VIEW, Uri.parse(apiModel.bank.url))
        val phoneintent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + apiModel.bank.phone))
        val locationintent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + apiModel.country.name))
        val context = LocalContext.current
        Box (modifier = modifier
            .padding(20.dp, 0.dp)) {
            Column(content = {
                Text(text = "Main info:", fontWeight = FontWeight.Bold)
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
                Text(text = "Bank:", fontWeight = FontWeight.Bold)
                Box{
                    LazyColumn(content = {
                        item {
                            Text(text = "  Name: ${apiModel.bank.name}")
                            Row { Text(text = "  Link: "); ClickableText(text = AnnotatedString(text = apiModel.bank.url), onClick = { startActivity(context, linkintent, null)}, style = TextStyle(textDecoration = TextDecoration.None, color = Color.Blue)) }
                            Text(text = "  City: ${apiModel.bank.city}")
                            Row { Text(text = "  Phone: "); ClickableText(text = AnnotatedString(text = apiModel.bank.phone), onClick = { startActivity(context, phoneintent, null)}, style = TextStyle(textDecoration = TextDecoration.None, color = Color.Blue)) }
                        }
                    })
                }
                Text(text = "Country:", fontWeight = FontWeight.Bold)
                Box{
                    LazyColumn(content = {
                        item {
                            Row { Text(text = "  Name: "); ClickableText(text = AnnotatedString(text = apiModel.country.name), onClick = { startActivity(context, locationintent, null)}, style = TextStyle(textDecoration = TextDecoration.None, color = Color.Blue)) }
                            Text(text = "  Alpha2: ${apiModel.country.alpha2}")
                            Text(text = "  Numeric: ${apiModel.country.numeric}")
                            Text(text = "  Emoji: ${apiModel.country.emoji}")
                            Text(text = "  Currency: ${apiModel.country.currency}")
                            Text(text = "  Latitude: ${apiModel.country.latitude}")
                            Text(text = "  Longitude: ${apiModel.country.longitude}")
                        }
                    })
                }
                Text(text = "Number:", fontWeight = FontWeight.Bold)
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