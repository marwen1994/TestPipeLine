package com.example.testpipeline.feature

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testpipeline.data.FoodResponse
import com.example.testpipeline.data.MainRepo
import kotlinx.coroutines.*

class MainViewModel(private val repository: MainRepo) : ViewModel() {

    val movieList = MutableLiveData<FoodResponse>()

    fun retrieveCategory() {
        CoroutineScope(Dispatchers.IO).launch(
            CoroutineExceptionHandler { _, _ ->
                movieList.postValue(null)
            }
        ) {
            try {
                val verifyAsync = async(Dispatchers.IO) {
                    repository.getAllMovies()
                }
                verifyAsync.await().let { list ->
                    Log.e("list" , list.categories?.size.toString())
                    movieList.postValue(
                        list
                    )
                }
            } catch (e: Exception) {
                Log.e("error" , e.toString())

                movieList.postValue(null)
            }
        }
    }
}