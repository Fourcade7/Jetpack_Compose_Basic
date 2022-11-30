package com.pr7.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.pr7.jetpack_compose.ui.theme.Jetpack_ComposeTheme

class JC_11_Password_TextFields : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    pr11()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun pr11() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var password by remember {
            mutableStateOf("")
        }
        var passwordtransform by remember {
            mutableStateOf(false)
        }
        var icon= if(passwordtransform){
            painterResource(id = R.drawable.ic_round_remove_red_eye_24)
        }else{
            painterResource(id = R.drawable.ic_round_visibility_off_24)
        }
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = { Text(text = "Enter your name") },
            label = { Text(text = "Password") },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                        contentDescription ="" )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    passwordtransform=!passwordtransform
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = ""
                    )
                }
            },
            visualTransformation = if (passwordtransform){
                PasswordVisualTransformation()
            }else{
                VisualTransformation.None
            }
        )
    }
}