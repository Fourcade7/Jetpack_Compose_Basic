package com.pr7.jetpack_compose

import android.os.Bundle
import androidx.compose.runtime.*
import androidx.compose.animation.core.*
import androidx.compose.ui.geometry.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
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
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            var value by remember {
                                mutableStateOf(0)
                            }
                            customComponent(indicatorValue = value)
                            TextField(
                                value = "$value",
                                onValueChange ={
                                    value=if (it.isNotEmpty()) it.toInt() else 0
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                )
                            )
                        }

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
    bigTextFontSize: TextUnit=MaterialTheme.typography.h3.fontSize,
    bigTextColor: Color=MaterialTheme.colors.onSurface,
    bigTextSuffix: String="GB",
    smallText: String="Remaining",
    smallTextFontSize: TextUnit=MaterialTheme.typography.h6.fontSize,
    smallTextColor: Color=MaterialTheme.colors.onSurface.copy(alpha = 0.3f)


    ) {
    var allowedIndicatorValue by remember {
        mutableStateOf(maxindicatorValue)
    }
    allowedIndicatorValue=if (indicatorValue <= maxindicatorValue){
        indicatorValue
    }else{
        maxindicatorValue
    }
    allowedIndicatorValue
    val animatedIndicatorValue= remember {
        Animatable(initialValue = 0f)
    }
    LaunchedEffect(key1 = allowedIndicatorValue){
        animatedIndicatorValue.animateTo(allowedIndicatorValue.toFloat())
    }
    val parcentage=(animatedIndicatorValue.value / maxindicatorValue)*100
    val sweepAngle by animateFloatAsState(
        targetValue = (2.4 * parcentage).toFloat(),
        animationSpec = tween(1000)
    )
    val recievedValue by animateIntAsState(
        targetValue = allowedIndicatorValue,
        animationSpec = tween(1000)
    )
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
                    sweepAngle = sweepAngle,
                    componentSize = componentSize,
                    indicatorColor = foregroundindicatorColor,
                    indicatorStrokeWidth = foregroundStrokeWidth
                )
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        embeddedElements(
            bigText = recievedValue,
            bigTextFontSize =bigTextFontSize ,
            bigTextColor =bigTextColor ,
            bigTextSuffix =bigTextSuffix ,
            smallText = smallText,
            smallTextColor = smallTextColor,
            smallTextFontSize =smallTextFontSize
        )
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

@Composable
fun embeddedElements(
    bigText:Int,
    bigTextFontSize:TextUnit,
    bigTextColor: Color,
    bigTextSuffix:String,
    smallText:String,
    smallTextColor:Color,
    smallTextFontSize:TextUnit
){

    Text(
        text = smallText,
        color = smallTextColor,
        fontSize = smallTextFontSize,
        textAlign = TextAlign.Center
    )
    Text(
        text = "$bigText ${bigTextSuffix.take(2)}",
        color = bigTextColor,
        fontSize = bigTextFontSize,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )

}


@Preview(showBackground = true)
@Composable
fun customComponentPreview() {
    customComponent()
}