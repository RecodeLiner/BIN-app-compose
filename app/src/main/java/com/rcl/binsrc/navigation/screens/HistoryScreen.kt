package com.rcl.binsrc.navigation.screens

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rcl.binsrc.navigation.screens.structs.BinCard
import com.rcl.binsrc.room.Bin
import com.rcl.binsrc.room.BinViewModel
import kotlinx.coroutines.DelicateCoroutinesApi

@OptIn(DelicateCoroutinesApi::class)
class HistoryScreen {
    private var list = mutableListOf<Bin>()
    private lateinit var context: Context
    private lateinit var mbinViewModel: BinViewModel

    @OptIn(DelicateCoroutinesApi::class)
    @Composable
    fun Screen() {
        Box(modifier = Modifier){
            /*Button(onClick = { GlobalScope.launch { Log.d("TAG",
                mbinViewModel.readAllData.value.toString()
            )} } ) {
                Text(text = "Button")
            }*/
            LazyColumn(modifier = Modifier.padding(1.dp)) {
                if (list.isNotEmpty()) {
                    items(list.size) {
                        BinCard().Card(list[it])
                    }
                }
                else{
                    item {
                        Text(text = "No data")
                    }
                }
            }
        }
    }
}