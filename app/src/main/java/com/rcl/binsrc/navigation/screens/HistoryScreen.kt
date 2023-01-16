package com.rcl.binsrc.navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.rcl.binsrc.R
import com.rcl.binsrc.navigation.screens.structs.BinCard
import com.rcl.binsrc.navigation.screens.structs.Tempstruct
import com.rcl.binsrc.room.Bin
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@OptIn(DelicateCoroutinesApi::class)
class HistoryScreen {
    private var list = mutableListOf<Bin>()

    init {
        val mbinViewModel = Tempstruct.BinViewModel
        mbinViewModel?.readAllData?.onEach { data ->
            Tempstruct.list = data as MutableList<Bin>
        }?.launchIn(GlobalScope)
    }

    @Composable
    fun Screen() {
        list = Tempstruct.list
        Box(modifier = Modifier.padding(0.dp,
            WindowInsets.systemBars
            .asPaddingValues()
            .calculateTopPadding(),  0.dp, 0.dp)) {
            LazyColumn(modifier = Modifier.padding(1.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                if (list.isNotEmpty()) {
                    items(list.size) {
                        BinCard().Card(list[it])
                    }
                }
                else{
                    item {
                        Text(text = LocalContext.current.getString(R.string.empty_history))
                    }
                }
            }
        }
    }
}