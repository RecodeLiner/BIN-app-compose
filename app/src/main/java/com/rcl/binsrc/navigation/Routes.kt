package com.rcl.binsrc.navigation

sealed class Routes(val routes: String) {
    object MainScreen : Routes("MainScreen")
    object HistoryScreen : Routes("HistoryScreen")
}