package com.example.testpipeline.feature.food.subcategory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testpipeline.data.MainRepo
import com.example.testpipeline.data.retrofit.BuildService
import com.example.testpipeline.databinding.ActivitySubCategoryBinding
import com.example.testpipeline.feature.food.MainViewModel
import com.example.testpipeline.feature.food.adapter.SubCategoryAdapter
import com.example.testpipeline.viewmodel.MyViewModelFactory

class SubCategoryActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySubCategoryBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = BuildService.getInstance()
    private var adapter: SubCategoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepo(retrofitService))).get(
            MainViewModel::class.java)
        viewModel.retrieveCategory("Canadian")
        setList()

    }

    private fun setList(){
        viewModel.subCategoryList.observe(this) {
            adapter = SubCategoryAdapter()
            it.meals?.let { it1 -> adapter?.addList (it1) }
            binding.list.adapter = adapter
        }
        val recyclerLayoutManager = GridLayoutManager(this, 2)
        binding.list.layoutManager = recyclerLayoutManager
    }
}