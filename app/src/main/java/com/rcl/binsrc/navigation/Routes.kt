package com.rcl.binsrc.navigation

sealed class Routes(val routes: String) {
    object MainList : Routes("MainList")
    object AddUI : Routes("AddUI")
}