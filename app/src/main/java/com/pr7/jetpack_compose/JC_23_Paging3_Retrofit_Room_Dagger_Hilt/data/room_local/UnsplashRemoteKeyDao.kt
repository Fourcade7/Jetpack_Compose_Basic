package com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.data.room_local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.model.UnsplashRemoteKeys
import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.utils.Constants


@Dao
interface UnsplashRemoteKeyDao {
    @Query("SELECT * FROM ${Constants.UNSPLASH_REMOTE_KEYS_TABLE} WHERE id=:id")
    fun getRemoteKeys(id:String): UnsplashRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addAllRemoteKeys(remoteKeys: List<UnsplashRemoteKeys>)

    @Query("DELETE FROM ${Constants.UNSPLASH_REMOTE_KEYS_TABLE}")
     fun deleteAllRemoteKeys()
}