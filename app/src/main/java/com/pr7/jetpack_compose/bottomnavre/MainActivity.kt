package com.pr7.jetpack_compose.bottomnavre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pr7.jetpack_compose.bottomnavre.screens.homeFragment
import com.pr7.jetpack_compose.bottomnavre.screens.profileFragment
import com.pr7.jetpack_compose.bottomnavre.screens.settingsFragment
import com.pr7.jetpack_compose.bottomnavre.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.ui.theme.PrCustomColor3
import com.pr7.jetpack_compose.ui.theme.PrCustomColor4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    bottomNavigationRe()
                }
            }
        }
    }
}


@Composable
fun installBottomnavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomnavScreens.Home.route
        ){
        composable(route=BottomnavScreens.Home.route){
            homeFragment()
        }
        composable(route=BottomnavScreens.Profile.route){
            profileFragment()
        }
        composable(route=BottomnavScreens.Settings.route){
            settingsFragment()
        }
    }
}

@Composable
fun bottomBar(
    navHostController: NavHostController
) {
    val screens= listOf(
        BottomnavScreens.Home,
        BottomnavScreens.Profile,
        BottomnavScreens.Settings
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentdestionation = navBackStackEntry?.destination

    BottomNavigation() {
        screens.forEach { screenn ->
            if (currentdestionation!=null){
                additems(
                    screens = screenn,
                    currentDestination =currentdestionation ,
                    navHostController =navHostController )
            }
        }
    }
}

@Composable
fun RowScope.additems(
    navHostController: NavHostController,
    screens: BottomnavScreens,
    currentDestination: NavDestination
) {
    BottomNavigationItem(
        selected = currentDestination.hierarchy.any {
              it.route==screens.route
        },
        onClick = {
                  navHostController.navigate(screens.route){
                      popUpTo(navHostController.graph.findStartDestination().id)
                      launchSingleTop=true
                  }
        },
        icon = {
               Icon(imageVector = screens.icon, contentDescription = "")
        },
        modifier =Modifier.background(PrCustomColor4),
        label = {
                Text(text = screens.title)
        },
        alwaysShowLabel = true,
        selectedContentColor = Color.DarkGray,
        unselectedContentColor =Color.LightGray

    )
}

@Preview(showBackground = true)
@Composable
fun bottomNavigationRe() {
    val navHostController= rememberNavController()
    Scaffold(
        bottomBar = {
            bottomBar(navHostController = navHostController)
        }) {
        installBottomnavGraph(navHostController = navHostController)
    }
}

