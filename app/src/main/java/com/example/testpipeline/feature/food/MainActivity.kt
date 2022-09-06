package com.example.testpipeline.feature.food

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testpipeline.data.BuildService
import com.example.testpipeline.data.MainRepo
import com.example.testpipeline.databinding.ActivityMainBinding
import com.example.testpipeline.feature.MyViewModelFactory
import com.example.testpipeline.feature.adapter.FoodAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
      private var adapter: FoodAdapter? = null
    private val retrofitService = BuildService.getInstance()
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepo(retrofitService))).get(
            MainViewModel::class.java)
        viewModel.movieList.observe(this) {
          adapter = FoodAdapter()
            it.categories?.let { it1 -> adapter?.addList (it1) }
            binding.list.adapter = adapter
        }
        viewModel.retrieveCategory()
        val recyclerLayoutManager = GridLayoutManager(this , 2)
        binding.list.layoutManager = recyclerLayoutManager

    }
}