package com.pr7.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.ui.theme.PrCustomColor

class JC_12_Gradient_Button : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                  pr12()

                }
            }
        }
    }
}



@Composable
fun gradientButtonPr(
    text:String,
    textColor:Color,
    gradient:Brush,
    onclick:()->Unit
){
    Button(
        modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),

        contentPadding = PaddingValues(),
        onClick = {onclick}
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .width(250.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .wrapContentHeight()
                ,
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = text, color = textColor)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun pr12(){

       gradientButtonPr(
           text = "Ok",
           textColor =Color.White ,
           gradient = Brush.horizontalGradient(
               colors = listOf(
                   PrCustomColor,
                   Color.White
               )
           )) {

       }


}





@Composable
fun GradientButton(
    text: String,
    gradient : Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = text)
        }
    }
}


@Preview
@Composable
private fun Content() {

    val gradient =
        Brush.horizontalGradient(listOf(Color(0xFF28D8A3), Color(0xFF00BEB2)))

    Column {
        GradientButton(
            text = "Gradient Button - Max Width",
            gradient = gradient,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
        GradientButton(
            text = "Gradient Button - Wrap Width",
            gradient = gradient,
            modifier = Modifier
                .wrapContentWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}



