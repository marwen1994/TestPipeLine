package com.example.testpipeline.data

import com.example.testpipeline.data.retrofit.ApiInterfaces

class MainRepo  (private val retrofitService: ApiInterfaces?) {

     suspend fun getAllCategories() = retrofitService?.getAllCategories()
     suspend fun getSubCategoryList (name: String) = retrofitService?.getSubCategoryFood(name)

}