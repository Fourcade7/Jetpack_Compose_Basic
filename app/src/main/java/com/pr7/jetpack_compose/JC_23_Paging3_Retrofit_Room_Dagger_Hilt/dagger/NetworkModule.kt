package com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.dagger

import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.data.network.UnsplashApi
import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {


    @Singleton
    @Provides
    fun provideHttpClient():OkHttpClient{
        return  OkHttpClient.Builder()
            .readTimeout(15,TimeUnit.SECONDS)
            .connectTimeout(15,TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideUnsplashApi(retrofit: Retrofit): UnsplashApi {
        return retrofit.create(UnsplashApi::class.java)
    }

}