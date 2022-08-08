package com.example.testpipeline

import androidx.lifecycle.ViewModelProvider
import com.example.testpipeline.data.BuildService
import com.example.testpipeline.data.MainRepo
import com.example.testpipeline.feature.MainViewModel
import com.example.testpipeline.feature.MyViewModelFactory
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    lateinit var viewModel: MainViewModel




    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}