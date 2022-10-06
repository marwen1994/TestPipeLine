package com.example.testpipeline.data.retrofit

import com.example.testpipeline.data.entities.FoodResponse
import com.example.testpipeline.data.entities.SubCategoryResponce
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterfaces {

    @GET("categories.php")
    suspend fun getAllCategories(): FoodResponse
    @GET("filter.php")
    suspend fun getSubCategoryFood(@Query("a") a: String) : SubCategoryResponce



}