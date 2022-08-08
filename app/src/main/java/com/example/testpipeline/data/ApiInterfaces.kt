package com.example.testpipeline.data

import androidx.viewbinding.BuildConfig
import com.example.testpipeline.BuildConfig.BASEURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterfaces {

    @GET("categories.php")
    suspend fun getAllCategories(): FoodResponse



}