package com.pr7.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pr7.jetpack_compose.ui.theme.Jetpack_ComposeTheme

class JC_14_TextFields_Character_LImit : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun pr14() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            var name by remember {
                mutableStateOf("")
            }
            val maxchar=10
            OutlinedTextField(
                value = name,
                onValueChange = {
                    if (it.length<maxchar){
                        name=it
                    }
                },
                label = {
                    Text(text = "Login")
                },
                placeholder = {
                    Text(text = "Enter your name")
                },
                maxLines = 1
            )
        }
}