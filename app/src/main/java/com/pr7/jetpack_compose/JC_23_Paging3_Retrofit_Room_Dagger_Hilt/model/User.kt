package com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.model

import androidx.room.Embedded

data class User constructor(
    @Embedded
    val links:UserLinks,
    val username:String
)
