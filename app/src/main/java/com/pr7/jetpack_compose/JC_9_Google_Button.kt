@file:OptIn(ExperimentalMaterialApi::class)

package com.pr7.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.ui.theme.PrCustomColor
import com.pr7.jetpack_compose.ui.theme.Shapes

class JC_9_Google_Button : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    pr9()
                }
            }
        }
    }
}


@Preview
@Composable
fun pr9() {
    var clicked by remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .wrapContentSize(),
        onClick = {clicked=!clicked},
        shape = Shapes.medium,
        border = BorderStroke(width = 1.dp, color = PrCustomColor)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)
        ) {

            Icon(
                painter = painterResource(id = R.drawable.googleflat),
                contentDescription = "googleicon",
                tint = Color.Unspecified,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)

            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Sign Up with Google")
            if (clicked){
                Spacer(modifier = Modifier.width(10.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(18.dp)
                        .height(18.dp)
                )
            }
            
        }

    }
}

