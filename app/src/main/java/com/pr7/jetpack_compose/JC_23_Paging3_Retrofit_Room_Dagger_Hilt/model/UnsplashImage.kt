package com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.utils.Constants.UNSPLASH_IMAGE_TABLE

@Entity(tableName = UNSPLASH_IMAGE_TABLE)
data class UnsplashImage constructor(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    @Embedded
    val urls:Urls,
    val likes:Int,
    @Embedded
    val user:User
)


