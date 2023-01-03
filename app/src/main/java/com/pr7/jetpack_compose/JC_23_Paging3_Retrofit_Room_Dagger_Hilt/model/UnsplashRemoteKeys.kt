package com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.utils.Constants.UNSPLASH_REMOTE_KEYS_TABLE

@Entity(tableName =UNSPLASH_REMOTE_KEYS_TABLE )
data class UnsplashRemoteKeys constructor(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val prevPage:Int?,
    val nextPage:Int?
)
