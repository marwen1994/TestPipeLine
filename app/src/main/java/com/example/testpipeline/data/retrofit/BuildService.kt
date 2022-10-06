package com.example.testpipeline.data.retrofit

import com.example.testpipeline.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BuildService {
        var retrofitService: ApiInterfaces? = null

        fun getInstance() : ApiInterfaces {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ApiInterfaces::class.java)
            }
            return retrofitService!!
        }
}