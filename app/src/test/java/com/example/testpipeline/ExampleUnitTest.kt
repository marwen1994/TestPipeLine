package com.example.testpipeline

import com.example.testpipeline.feature.food.MainViewModel
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