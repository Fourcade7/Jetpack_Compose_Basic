package com.pr7.jetpack_compose.JC_17_Navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun detailScreen(
    navController: NavController
){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.clickable {
            //navController.popBackStack()
            navController.navigate(Scrrens.Home.route){
                popUpTo(Scrrens.Home.route){
                    inclusive =true
                }
            }
            },
            text = "Detail",
            color = MaterialTheme.colors.primaryVariant,
            fontSize = MaterialTheme.typography.h2.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun detailScreenPreview(){
    detailScreen(navController = rememberNavController())
}