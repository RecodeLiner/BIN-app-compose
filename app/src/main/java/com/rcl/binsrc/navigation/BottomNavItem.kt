package com.rcl.binsrc.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title:String, var icon: ImageVector, var route:String){
    object Main : BottomNavItem("Main", Icons.Filled.Home,"MainScreen")
    object History : BottomNavItem("History", Icons.Filled.History,"HistoryScreen")
}