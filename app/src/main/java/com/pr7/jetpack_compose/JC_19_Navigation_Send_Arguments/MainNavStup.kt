package com.pr7.jetpack_compose.JC_19_Navigation_Send_Arguments

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pr7.jetpack_compose.JC_18_Navigation_Fragment_Call.GOOGLE
import com.pr7.jetpack_compose.JC_18_Navigation_Fragment_Call.YANDEX


@Composable
fun mainNavSetup(
    navHostController: NavHostController
){

    NavHost(
        navController = navHostController,
        startDestination = GOOGLE
    ){
        composable(route = GOOGLE){
            google(navHostController)
        }
        composable(
            route = YANDEX,
            arguments = listOf(navArgument("id"){
                type= NavType.IntType
            })
        ){
            Log.d("PR77777", "mainNavSetup: ${it.arguments?.getInt("id")}")
            yandex()
        }
    }
}