package com.pr7.jetpack_compose

import android.os.Bundle
import androidx.compose.ui.geometry.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.ui.theme.Jetpack_ComposeTheme

class JC_15_Canvas_Custom_UI_Progressbar : ComponentActivity() {
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
fun customComponent(
    canvassize: Dp = 300.dp,
    indicatorValue: Int = 0,
    maxindicatorValue: Int = 100,
    backgroundindicatorColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f),
    backgroundStrokeWidth: Float = 100f,
    foregroundindicatorColor: Color = MaterialTheme.colors.primary,
    foregroundStrokeWidth: Float = 100f,


    ) {
    Column(
        modifier = Modifier
            .size(canvassize)
            .drawBehind {
                val componentSize = size / 1.25f
                backgroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = backgroundindicatorColor,
                    indicatorStrokeWidth = backgroundStrokeWidth
                )
                foregroundIndicator(
                    sweepAngle = 10f,
                    componentSize =componentSize,
                    indicatorColor =foregroundindicatorColor,
                    indicatorStrokeWidth = foregroundStrokeWidth
                )
            }

    ) {

    }
}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = 240f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x =(size.width-componentSize.width)/2f ,
            y =(size.height-componentSize.height)/2f
        )

    )
}
fun DrawScope.foregroundIndicator(
    sweepAngle:Float,
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x =(size.width-componentSize.width)/2f ,
            y =(size.height-componentSize.height)/2f
        )

    )
}

@Preview(showBackground = true)
@Composable
fun customComponentPreview() {
    customComponent()
}