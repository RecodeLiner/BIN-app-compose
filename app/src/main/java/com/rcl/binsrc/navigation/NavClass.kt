package com.rcl.binsrc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rcl.binsrc.navigation.screens.HistoryScreen
import com.rcl.binsrc.navigation.screens.MainScreen

class NavClass{
    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = Routes.MainScreen.routes) {
            composable(Routes.MainScreen.routes) {
                MainScreen().Screen(navController = navController)
            }
            composable(Routes.HistoryScreen.routes) {
                HistoryScreen().Screen()
            }
        }
    }
}