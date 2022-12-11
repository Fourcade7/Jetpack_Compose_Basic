package com.pr7.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.ui.theme.Jetpack_ComposeTheme

class JC_16_Text_Animation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    pr16()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun pr16() {
    var animationvalue by remember {
        mutableStateOf(20)
    }
    val myvalue by animateIntAsState(
        targetValue = animationvalue,
        animationSpec = tween(1000)
    )
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.padding(vertical = 25.dp),
            text = myvalue.toString(),
            fontSize = MaterialTheme.typography.h2.fontSize
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp),
            onClick = {
                animationvalue=100
            }) {
            Text(text = "Go")

            Text(text = "777")
        }
    }
}