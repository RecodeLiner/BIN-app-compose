package com.rcl.binsrc.navigation.screens

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.rcl.binsrc.R
import com.rcl.binsrc.retrofit.ApiModel
import com.rcl.binsrc.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainScreen {
    @Composable
    fun Screen() {
        InputBlock()
    }

    lateinit var apiModel : ApiModel
    var Temp = mutableStateOf("")

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun InputBlock(modifier: Modifier = Modifier) {
        val context = LocalContext.current
        val textState = remember { mutableStateOf("") }

        Column(
            verticalArrangement = Arrangement.Center,
        ){
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(LocalContext.current.getString(R.string.label_text)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp)
                    .border(1.dp, MaterialTheme.colorScheme.onSurface, RoundedCornerShape(4.dp))
            )
            Button(
                onClick = { loadData(textState.value, context) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(LocalContext.current.getString(R.string.button_text))
            }
            Text(text = Temp.value)
        }
    }

    fun loadData(BIN: String, context: Context) {
        val regEx = "^[0-9]{8}$".toRegex()
        val res = regEx.matches(BIN)
        if(!res){
            Temp.value = context.getString(R.string.invalid_bin)
            return
        }
        RetrofitInstance.retrofitRq.getFromApi(BIN).enqueue(
            object : Callback<ApiModel> {
                override fun onResponse(call: Call<ApiModel>, response: Response<ApiModel>) {
                    if(response.code()==200) {
                        apiModel = response.body()!!
                        Temp.value = apiModel.bank.name
                    }
                    else{
                        Temp.value = context.getString(R.string.unknown_code) + response.code()
                    }
                }
                override fun onFailure(call: Call<ApiModel>, t: Throwable) {
                    Temp.value = t.message!!
                }
            }
        )
    }
}

