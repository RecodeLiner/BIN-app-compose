package com.rcl.binsrc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = Routes.MainList.routes) {
            //composable(Routes.MainList.routes) { Routes.MainList().MainList(navController) }
            //composable(Routes.AddUI.routes) { Routes.AddUI().AddUI() }
        }
}