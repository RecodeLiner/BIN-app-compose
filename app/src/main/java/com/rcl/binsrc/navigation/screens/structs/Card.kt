package com.rcl.binsrc.navigation.screens.structs

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.rcl.binsrc.retrofit.ApiModel


@Composable
fun Card(cardModel: ApiModel) {
    val shadowedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
    val context = LocalContext.current
    ElevatedCard(modifier = Modifier.fillMaxWidth()){
        Row(
            modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column {
                    Text(text = "BIN", color = shadowedTextColor)
                    Text(text = cardModel.bin)
                }
                Column {
                    Text("Scheme", color = shadowedTextColor)
                    Text(cardModel.scheme)
                }
                if (cardModel.brand != null) {
                    Column {
                        Text(text = "Brand", color = shadowedTextColor)
                        Text(cardModel.brand)
                    }
                }
                Column {
                    Text(text = "Card number", color = shadowedTextColor)
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Column {
                            Text(
                                "Length",
                                color = shadowedTextColor,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(cardModel.number.length.toString())
                        }
                        Column {
                            Text(
                                "Luhn",
                                color = shadowedTextColor,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(cardModel.number.luhn.toString().capitalize(Locale.current))
                        }
                    }
                }
                if (cardModel.type != null) {
                    Column {
                        Text(
                            "Type",
                            color = shadowedTextColor,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(cardModel.type.capitalize(Locale.current))
                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (cardModel.prepaid != null) {
                    Column {
                        Text(text = "Prepaid", color = shadowedTextColor)
                        Text(cardModel.prepaid.toString().capitalize(Locale.current))
                    }
                }
                Column {
                    Text(text = "Country", color = shadowedTextColor)
                    ClickableText(
                        text = AnnotatedString(text = cardModel.country.emoji + " " + cardModel.country.name),
                        onClick = {
                            startActivity(context,  Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + cardModel.country.name)), null)
                        }
                    )
                    Text(
                        text = "(latitude: " + cardModel.country.latitude + ", longitude: " + cardModel.country.longitude + ")",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Column {
                    Text(text = "Currency", color = shadowedTextColor)
                    Text(cardModel.country.currency)
                }
                if (cardModel.bank.name != null) {
                    Column {
                        Text(text = "Bank", color = shadowedTextColor)
                        Text(text = cardModel.bank.name + ", " + cardModel.bank.city)
                        ClickableText(text = AnnotatedString(cardModel.bank.url),
                            style = MaterialTheme.typography.bodySmall,
                            onClick = {
                                if (!cardModel.bank.url.startsWith("http://")
                                    && !cardModel.bank.url.startsWith("https://")
                                ) {
                                    startActivity(
                                        context, Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse("http://" + cardModel.bank.url)
                                        ), null
                                    )
                                } else {
                                    startActivity(
                                        context,
                                        Intent(Intent.ACTION_VIEW, Uri.parse(cardModel.bank.url)),
                                        null
                                    )
                                }
                            })
                        ClickableText(text = AnnotatedString(cardModel.bank.phone),
                            style = MaterialTheme.typography.bodySmall,
                            onClick = {
                                startActivity(
                                    context, Intent(
                                        Intent.ACTION_DIAL, Uri.parse("tel:" + cardModel.bank.phone)
                                    ), null
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "temp")
@Composable
fun CardPreview() {
    val temp = ApiModel(
        bin = "12345678",
        scheme = "visa",
        type = "debit",
        bank = com.rcl.binsrc.retrofit.Bank(
            name = "JPMorgan Chase Bank, N.A.",
            url = "www.chase.com",
            phone = "+1-800-935-9935",
            city = "New York"
        ),
        country = com.rcl.binsrc.retrofit.Country(
            numeric = "840",
            alpha2 = "US",
            name = "United States of America",
            emoji = "🇺🇸",
            latitude = "38",
            longitude = "-97",
            currency = "USD",
        ),
        number = com.rcl.binsrc.retrofit.Number(
            length = 16,
            luhn = true
        ),
        brand = "Visa",
        prepaid = false
    )
    Card(temp)
}