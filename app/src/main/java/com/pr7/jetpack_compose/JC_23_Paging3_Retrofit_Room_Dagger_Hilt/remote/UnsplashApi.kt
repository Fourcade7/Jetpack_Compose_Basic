package com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.remote

import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.model.UnsplashImage
import com.pr7.jetpack_compose.JC_23_Paging3_Retrofit_Room_Dagger_Hilt.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface UnsplashApi {
    @Headers("Authorization: Client-ID $API_KEY")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page:Int,
        @Query("per_page") per_page:Int
    ):List<UnsplashImage>

    @Headers("Authorization: Client-ID $API_KEY")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("page") page:Int,
        @Query("per_page") per_page:Int
    ):List<UnsplashImage>
}