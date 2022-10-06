package com.example.testpipeline.feature.food

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testpipeline.data.entities.FoodResponse
import com.example.testpipeline.data.MainRepo
import com.example.testpipeline.data.entities.SubCategoryResponce
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
                    repository.getAllCategories()
                }
                verifyAsync.await().let { list ->
                    Log.e("list" , list?.categories?.size.toString())
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
    val subCategoryList = MutableLiveData<SubCategoryResponce>()

    fun retrieveCategory(name : String) {
        CoroutineScope(Dispatchers.IO).launch(
            CoroutineExceptionHandler { _, _ ->
                subCategoryList.postValue(null)
            }
        ) {
            try {
                val verifyAsync = async(Dispatchers.IO) {
                    repository.getSubCategoryList(name)
                }
                verifyAsync.await().let { list ->
                    Log.e("list" , list?.meals?.size.toString())
                    subCategoryList.postValue(
                        list
                    )
                }
            } catch (e: Exception) {
                Log.e("error" , e.toString())

                subCategoryList.postValue(null)
            }
        }
    }
}