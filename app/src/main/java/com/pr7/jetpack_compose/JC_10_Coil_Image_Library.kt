package com.pr7.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.pr7.jetpack_compose.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.ui.theme.PrCustomColor

class JC_10_Coil_Image_Library : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    pr10()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun pr10(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrCustomColor),
        contentAlignment = Alignment.Center
    ){
        val painter= rememberImagePainter(
            data = "https://pbs.twimg.com/media/Dw6W3xbX0AAQQ-s.jpg",
            builder = {
                 placeholder(R.drawable.googleflat)
                 crossfade(1000)
                 error(R.drawable.google)
                 transformations(
                     CircleCropTransformation(),


                 )

            }
        )
        Image(
            painter = painter,
            contentDescription = "axax",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        )
        val painterstate=painter.state
    }

}