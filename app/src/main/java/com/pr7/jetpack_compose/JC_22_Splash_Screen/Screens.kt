package com.pr7.jetpack_compose.JC_22_Splash_Screen

sealed class Screens constructor(
    val route:String
){
    object Splash : Screens(route = "splash_screen")
    object Home : Screens(route = "home_screen")
}