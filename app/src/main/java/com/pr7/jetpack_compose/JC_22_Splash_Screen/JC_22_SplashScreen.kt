package com.pr7.jetpack_compose.JC_22_Splash_Screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pr7.jetpack_compose.JC_22_Splash_Screen.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.JC_22_Splash_Screen.ui.theme.Purple700
import kotlinx.coroutines.delay
import java.nio.channels.FileLock

class JC_22_SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navHostController= rememberNavController()
                    setupNavGraph(navHostController = navHostController)
                }
            }
        }
    }
}


@Composable
fun setupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route){
            animatedSplashScreen(navHostController = navHostController)
        }
        composable(route = Screens.Home.route){
            Box(modifier = Modifier.fillMaxSize())
        }
    }
}


@Composable
fun splash(alpha : Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.DarkGray else Purple700),
        contentAlignment = Alignment.Center
    ){
        Icon(
            imageVector =Icons.Default.Email,
            tint = Color.White,
            contentDescription = "",
            modifier = Modifier
                .size(100.dp)
                .alpha(alpha=alpha)
        )
    }
}

@Composable
fun animatedSplashScreen(navHostController: NavHostController) {
    var startanimation by remember {
        mutableStateOf(false)
    }
    val alphaanim= animateFloatAsState(
        targetValue =if (startanimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        )
    )

    LaunchedEffect(key1 = true){
        startanimation=true
        delay(4000)
        navHostController.popBackStack()
        navHostController.navigate(Screens.Home.route)
    }
    splash(alpha = alphaanim.value)
}