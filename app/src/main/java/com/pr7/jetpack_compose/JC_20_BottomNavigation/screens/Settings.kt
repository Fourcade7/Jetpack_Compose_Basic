package com.pr7.jetpack_compose.JC_20_BottomNavigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.pr7.jetpack_compose.ui.theme.PrCustomColor


@Preview(showBackground = true)
@Composable
fun settingsScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrCustomColor),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Settings",
            fontSize = MaterialTheme.typography.h2.fontSize
        )
    }
}