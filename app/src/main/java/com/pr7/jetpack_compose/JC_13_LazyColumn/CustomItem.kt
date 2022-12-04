package com.pr7.jetpack_compose.JC_13_LazyColumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.JC_13_LazyColumn.model.Person


@Composable
fun customItem(person: Person){

    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        Text(
            text = "${person.age}",
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.firstName,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
        //Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = person.lastName,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showBackground = true)
@Composable
fun previewCustomItem(){
    customItem(
        person = Person(
            id = 0,
            firstName = "Pr",
            lastName = "Ae",
            age = 24
        )
    )
}