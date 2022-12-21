package com.pr7.jetpack_compose.JC_17_Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun setupNavgraph(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination =Scrrens.Home.route
    ){
        composable(
            route = Scrrens.Home.route
        ){
            homeScreen(navController = navHostController )
        }
        composable(
            route = Scrrens.Detail.route
        ){
            detailScreen(navController = navHostController)
        }
    }
}

