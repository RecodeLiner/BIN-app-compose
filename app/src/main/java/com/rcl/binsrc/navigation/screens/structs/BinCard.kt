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
import com.rcl.binsrc.R
import com.rcl.binsrc.room.Bin


class BinCard{

    @Composable
    fun Card(Bin: Bin){
        val shadowedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        val context = LocalContext.current
        ElevatedCard(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Column {
                        Text(text = context.getString(R.string.bin_code), color = shadowedTextColor)
                        Text(text = Bin.bin)
                    }
                    if (Bin.scheme!= null) {
                        Column {
                            Text(text = context.getString(R.string.scheme), color = shadowedTextColor)
                            Text(text = Bin.scheme)
                        }
                    }
                    if (Bin.brand != null) {
                        Column {
                            Text(text = context.getString(R.string.brand), color = shadowedTextColor)
                            Text(Bin.brand)
                        }
                    }
                    if (Bin.number_length != null) {
                        Column {
                            Text(text = context.getString(R.string.card_number), color = shadowedTextColor)
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Column {
                                    Text(text = context.getString(R.string.card_number_length), color = shadowedTextColor, style = MaterialTheme.typography.bodySmall)
                                    Text(text = Bin.number_length.toString())
                                }
                                Column {
                                    Text(text = context.getString(R.string.card_number_luhn), color = shadowedTextColor, style = MaterialTheme.typography.bodySmall)
                                    Text(text = Bin.number_luhn.toString().capitalize(Locale.current))
                                }
                            }
                        }
                    }
                    if (Bin.type != null) {
                        Column {
                            Text(text = context.getString(R.string.type), color = shadowedTextColor, style = MaterialTheme.typography.bodySmall)
                            Text(text = Bin.type.capitalize(Locale.current))
                        }
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    if (Bin.prepaid != null) {
                        Column {
                            Text(text = context.getString(R.string.prepaid), color = shadowedTextColor)
                            Text(text = Bin.prepaid.toString().capitalize(Locale.current))
                        }
                    }
                    Column {
                        Text(text = context.getString(R.string.country), color = shadowedTextColor)
                        ClickableText(text = AnnotatedString(text = Bin.country_emoji + " " + Bin.country_name), onClick = { startActivity(context, Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + Bin.country_name)),null) })
                        Text(text = "(${context.getString(R.string.latitude)}: ${Bin.country_latitude}, ${context.getString(R.string.longitude)}: ${Bin.country_longitude})}", style = MaterialTheme.typography.bodySmall)
                    }
                    Column {
                        Text(text = context.getString(R.string.currency), color = shadowedTextColor)
                        Text(Bin.country_currency)
                    }
                    if (Bin.bank_name != null) {
                        Column {
                            Text(text = context.getString(R.string.bank), color = shadowedTextColor)
                            Text(text = Bin.bank_name)
                            if (Bin.bank_url != null){
                                ClickableText(text = AnnotatedString(Bin.bank_url), style = MaterialTheme.typography.bodySmall, onClick = { if (!Bin.bank_url.startsWith("http://") && !Bin.bank_url.startsWith("https://")) { startActivity(context, Intent(Intent.ACTION_VIEW, Uri.parse("http://" + Bin.bank_url)),null) } else { startActivity(context, Intent(Intent.ACTION_VIEW, Uri.parse(Bin.bank_url)), null) }})
                            }
                            if (Bin.bank_phone!=null){ ClickableText(text = AnnotatedString(Bin.bank_phone), style = MaterialTheme.typography.bodySmall, onClick = { startActivity(context, Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Bin.bank_phone)),null) }) }
                        }
                    }
                }
            }
        }
    }

    @Preview(name = "temp")
    @Composable
    fun CardPreview() {
        val temp = Tempstruct.temp2
        Card(temp)
    }
}