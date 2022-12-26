package com.pr7.jetpack_compose.JC_20_BottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomScreens constructor(
    val route:String,
    val title:String,
    val icon:ImageVector,

){
    object Home:BottomScreens(route = "home", title = "Home", icon =Icons.Default.Home)
    object Profile:BottomScreens(route = "profile", title = "Profile", icon =Icons.Default.Person)
    object Settings:BottomScreens(route = "settings", title = "Profile", icon =Icons.Default.Settings)
}
