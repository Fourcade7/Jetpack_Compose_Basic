package com.pr7.jetpack_compose

import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.ui.theme.Jetpack_ComposeTheme

class JC_2_Column_and_Row : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  columndandrow()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun columndandrow(){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        //verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Uaxaxax")
        Text(text = "Uaxaxax")
        Text(text = "Uaxaxax")
        Surface(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp),
            color = MaterialTheme.colors.primaryVariant,
            shape = RoundedCornerShape(8.dp),
            elevation = 5.dp,

        ) {
            Text(text = "Uaxaxax",textAlign = TextAlign.Center)
        }
    }

}

