package com.rcl.binsrc.navigation.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rcl.binsrc.R
import com.rcl.binsrc.navigation.screens.structs.BinCard
import com.rcl.binsrc.retrofit.ApiModel
import com.rcl.binsrc.retrofit.Bank
import com.rcl.binsrc.retrofit.Country
import com.rcl.binsrc.retrofit.Number
import com.rcl.binsrc.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainScreen {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun Screen(navController: NavHostController) {
        InputBlock()
    }

    lateinit var apiModel: ApiModel
    var intapimod = mutableStateOf(ApiModel(Bank("", "", "",""), "", Country("", "", "", 0, 0, "", ""), Number(0, false), false, "", ""))
    var temp = mutableStateOf("")
    var visible = mutableStateOf(false)

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun InputBlock(modifier: Modifier = Modifier) {
        val context = LocalContext.current
        val textState = remember { mutableStateOf("") }
        Box(Modifier.fillMaxSize()) {
            Column(Modifier.align(Alignment.Center)) {
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
                if (visible.value) {
                    BinCard().Card(intapimod.value)
                }
            }
        }
    }
        private fun loadData(BIN: String, context: Context) {
            val regEx = "^[0-9]{8}$".toRegex()
            val res = regEx.matches(BIN)
            if (!res) {
                temp.value = context.getString(R.string.invalid_bin)
                return
            }
            RetrofitInstance.retrofitRq.getFromApi(BIN).enqueue(
                object : Callback<ApiModel> {
                    override fun onResponse(call: Call<ApiModel>, response: Response<ApiModel>) {
                        when (response.code()) {
                            200 -> {
                                apiModel = response.body()!!
                                intapimod.value = apiModel
                                temp.value = apiModel.bank.name!!
                                visible.value = true
                            }

                            404 -> {
                                temp.value = context.getString(R.string.not_found)
                            }

                            else -> {
                                temp.value =
                                    context.getString(R.string.unknown_code) + response.code()
                            }
                        }
                    }

                    override fun onFailure(call: Call<ApiModel>, t: Throwable) {
                        temp.value = t.message!!
                    }
                }
            )
        }
    }

