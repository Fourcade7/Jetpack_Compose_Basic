package com.pr7.jetpack_compose.JC_19_Navigation_Send_Arguments

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.pr7.jetpack_compose.JC_18_Navigation_Fragment_Call.YANDEX


@Composable
fun google(
   navController: NavController
){
    Box(
        modifier =Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.clickable {
               navController.navigate(route = passId(7))
            },
            text = "Google",
            fontSize = MaterialTheme.typography.h3.fontSize,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold
        )
    }
}