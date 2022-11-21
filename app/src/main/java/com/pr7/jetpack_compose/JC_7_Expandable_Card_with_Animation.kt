@file:OptIn(ExperimentalMaterialApi::class)

package com.pr7.jetpack_compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateRectAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.ui.theme.Shapes
import com.pr7.jetpack_compose.ui.theme.backgrounddarkcolor

class JC_7_Expandable_Card_with_Animation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()

                        .background(backgrounddarkcolor)
                        .padding(15.dp),


                ) {
                    expandableCard()
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun expandableCard(){

    var clicked by remember {
        mutableStateOf(false)
    }
    val rotatestate by animateFloatAsState(
        targetValue = if (clicked) 180f else 0f
    )
    
    Card(
        modifier = Modifier

            .padding(0.dp,0.dp)
            .fillMaxWidth()
            .padding(0.dp)
            .animateContentSize(
                animationSpec = tween(
                    delayMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape= Shapes.medium,
        onClick = {
            clicked=!clicked
        }

    ) {
        Column(
            modifier = Modifier
                .padding(10.dp,10.dp)
                .fillMaxWidth()
                .padding(0.dp)

        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = "Qora Tappi",
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h6.fontSize
                )
                IconButton(
                    modifier = Modifier
                        .weight(1F)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotatestate),

                    onClick = { 
                        clicked=!clicked
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Dwop down arrow"
                    )
                }
            }

            if (clicked){
                Text(text = "Qora tappi qissasi Dwop down arrow AXaXaxa xaxaxaxaxaxaxaxaxax axaxaxDwop down arrow AXaXaxa xaxaxaxaxaxaxaxaxax axaxaxDwop down arrow AXaXaxa xaxaxaxaxaxaxaxaxax axaxax")
            }

        }



    }
    
}

