package com.pr7.jetpack_compose.JC_19_Navigation_Send_Arguments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.pr7.jetpack_compose.JC_19_Navigation_Send_Arguments.ui.theme.Orange


@Preview(showBackground = true)
@Composable
fun yandex(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Yandex",
            fontSize = MaterialTheme.typography.h3.fontSize,
            color = Orange,
            fontWeight = FontWeight.Bold
        )
    }
}