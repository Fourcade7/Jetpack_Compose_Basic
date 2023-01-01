package com.pr7.jetpack_compose.bottomnavre

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector



sealed class BottomnavScreens constructor(
    val route:String,
    val title:String,
    val icon:ImageVector
){
    object Home:BottomnavScreens(route = "home_screen", title = "home", icon =Icons.Default.Home)
    object Profile:BottomnavScreens(route = "profile_screen", title = "profile", icon =Icons.Default.Person)
    object Settings:BottomnavScreens(route = "settings_screen", title = "settings", icon =Icons.Default.Settings)
}