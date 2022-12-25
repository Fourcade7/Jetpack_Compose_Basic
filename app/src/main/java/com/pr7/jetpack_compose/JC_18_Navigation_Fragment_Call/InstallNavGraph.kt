package com.pr7.jetpack_compose.JC_18_Navigation_Fragment_Call

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun installNavGraph(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = "home_screen"
    ){
        composable(
            route = "home_screen"
        ){
            home()
        }
        composable(
            route = "detail_screen"
        ){
            detail()
        }
    }
}