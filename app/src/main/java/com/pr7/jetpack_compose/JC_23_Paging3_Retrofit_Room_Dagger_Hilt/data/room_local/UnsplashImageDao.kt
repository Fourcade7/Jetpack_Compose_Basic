package com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.data.room_local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.model.UnsplashImage
import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.utils.Constants.UNSPLASH_IMAGE_TABLE


@Dao
interface UnsplashImageDao {

    @Query("SELECT * FROM ${UNSPLASH_IMAGE_TABLE}")
    fun getAllImages():PagingSource<Int,UnsplashImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addImages(image:List<UnsplashImage>)

    @Query("DELETE FROM ${UNSPLASH_IMAGE_TABLE}")
     fun deleteAllImages()
}