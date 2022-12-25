package com.pr7.jetpack_compose.JC_18_Navigation_Fragment_Call

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pr7.jetpack_compose.JC_18_Navigation_Fragment_Call.ui.theme.Jetpack_ComposeTheme

class JC_18_Fragment_Call : ComponentActivity() {
    
    lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme

                    navHostController= rememberNavController()
                    //installNavGraph(navHostController = navHostController)


                    Column(
                        modifier = Modifier
                            .width(200.dp)
                            .wrapContentHeight()
                    ) {
                        Button(
                            onClick = {
                                navHostController.navigate(route = "detail_screen")
                            }) {
                            Text(text = "Clickme")

                        }
                        installNavGraph(navHostController = navHostController)
                        //navHostController.navigate(route = "home_screen")


                    }


            }
        }
    }
}




