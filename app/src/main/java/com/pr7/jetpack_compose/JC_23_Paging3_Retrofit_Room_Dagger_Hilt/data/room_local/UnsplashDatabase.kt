package com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.data.room_local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.model.UnsplashImage
import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class,UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase:RoomDatabase() {
    abstract fun unsplashImageDao():UnsplashImageDao
    abstract fun unsplashRemoteKeyDao():UnsplashRemoteKeyDao
}