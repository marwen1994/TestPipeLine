package com.example.testpipeline.data

class MainRepo  (private val retrofitService: ApiInterfaces) {

        suspend fun getAllMovies() = retrofitService.getAllCategories()
}