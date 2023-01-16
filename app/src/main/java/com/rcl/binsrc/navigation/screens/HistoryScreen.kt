package com.rcl.binsrc.navigation.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rcl.binsrc.navigation.screens.structs.BinCard
import com.rcl.binsrc.navigation.screens.structs.Tempstruct
import com.rcl.binsrc.room.Bin
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@OptIn(DelicateCoroutinesApi::class)
class HistoryScreen {
    var list: List<Bin> = listOf()
    init {
        val viewModel = Tempstruct.BinViewModel!!

        viewModel.readAllData.onEach { data ->
            list = data;
            Log.d("HistoryScreen", "init: $list")
        }.launchIn(GlobalScope)

    }

    @Composable
    fun Screen() {
        Box(modifier = Modifier.padding(0.dp,
            WindowInsets.systemBars
            .asPaddingValues()
            .calculateTopPadding(),  0.dp, 0.dp)) {
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