package com.pr7.jetpack_compose.JC_17_Navigation



sealed class Scrrens constructor(val route:String){
    object Home:Scrrens(route = "home_screen")
    object Detail:Scrrens(route = "detail_screen")
}