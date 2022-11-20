package com.pr7.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.ui.theme.Jetpack_ComposeTheme

class JC_6_Text_Subscript_and_SuperScript : ComponentActivity() {
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


@Composable
fun pr6(normaltext:String,subtext:String){

    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                baselineShift = BaselineShift.None
            )
        ){
            append(normaltext)
        }
        withStyle(
            style = SpanStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                baselineShift = BaselineShift.Subscript
            )
        ){
        append(subtext)
        }

    })

}


