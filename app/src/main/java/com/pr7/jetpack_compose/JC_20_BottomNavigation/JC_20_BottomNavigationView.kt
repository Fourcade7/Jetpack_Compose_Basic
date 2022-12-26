package com.pr7.jetpack_compose.JC_20_BottomNavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pr7.jetpack_compose.JC_20_BottomNavigation.screens.homeScreen
import com.pr7.jetpack_compose.JC_20_BottomNavigation.screens.profileScreen
import com.pr7.jetpack_compose.JC_20_BottomNavigation.screens.settingsScreen
import com.pr7.jetpack_compose.JC_20_BottomNavigation.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.ui.theme.PrCustomColor

class JC_20_BottomNavigationView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {

                bottomNavigation()

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun bottomNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            bottomBar(navController = navController)
        }
    ) {
        bottomNavGraph(navController = navController)
    }

}

@Composable
fun bottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomScreens.Home,
        BottomScreens.Profile,
        BottomScreens.Settings,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentdestination = navBackStackEntry?.destination
    BottomNavigation {
        screens.forEach {screen->
            if (currentdestination != null) {
                addItem(
                    screens =screen ,
                    currentDestination = currentdestination,
                    navController =navController
                )
            }
        }
    }
}

@Composable
fun RowScope.addItem(
    screens: BottomScreens,
    currentDestination: NavDestination,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screens.title)
        },
        icon = {
            Icon(imageVector = screens.icon, contentDescription = "")
        },
        selected = currentDestination.hierarchy.any {
            it.route == screens.route
        },
        unselectedContentColor = Color.DarkGray,
        //unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        selectedContentColor = PrCustomColor,
        onClick = {
        navController.navigate(screens.route){
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop=true
        }
        }
    )
}

@Composable
fun bottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomScreens.Settings.route
    ) {
        composable(route = BottomScreens.Home.route) { homeScreen() }
        composable(route = BottomScreens.Profile.route) { profileScreen() }
        composable(route = BottomScreens.Settings.route) { settingsScreen() }
    }
}

