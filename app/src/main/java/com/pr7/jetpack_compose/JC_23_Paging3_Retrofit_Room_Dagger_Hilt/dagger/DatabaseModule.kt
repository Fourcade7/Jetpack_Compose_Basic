package com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.dagger

import android.content.Context
import androidx.compose.ui.geometry.RoundRect
import androidx.room.Room
import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.data.room_local.UnsplashDatabase
import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.utils.Constants.UNSPLASH_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ):UnsplashDatabase{
        return Room.databaseBuilder(
            context,
            UnsplashDatabase::class.java,
            UNSPLASH_DATABASE
        ).build()
    }
}