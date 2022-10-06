package com.example.testpipeline.feature.food.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testpipeline.data.retrofit.BuildService.retrofitService
import com.example.testpipeline.data.MainRepo
import com.example.testpipeline.data.entities.Food
import com.example.testpipeline.databinding.FragmentCategoryFoodBinding
import com.example.testpipeline.feature.food.MainActivity
import com.example.testpipeline.viewmodel.MyViewModelFactory
import com.example.testpipeline.feature.food.MainViewModel
import com.example.testpipeline.feature.food.subcategory.SubCategoryActivity
import com.example.testpipeline.feature.food.adapter.FoodAdapter

class CategoryFoodFragment : Fragment() {
    lateinit var binding : FragmentCategoryFoodBinding
    lateinit var viewModel: MainViewModel
    private var adapter: FoodAdapter? = null
    private val categoryList: RecyclerView by lazy { binding.list }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepo(retrofitService))).get(
            MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.retrieveCategory()
        setList()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCategoryFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setList(){
        viewModel.movieList.observe(viewLifecycleOwner) {
            adapter = FoodAdapter(object : FoodAdapter.OnClick{
                override fun onClickItem(food: Food) {
                    startActivity(Intent(activity as  MainActivity , SubCategoryActivity::class.java))
                }

            })
            it.categories?.let { it1 -> adapter?.addList (it1) }
            categoryList.adapter = adapter
        }
        val recyclerLayoutManager = LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
        binding.list.layoutManager = recyclerLayoutManager
    }
    companion object {

        @JvmStatic
        fun newInstance() = CategoryFoodFragment()
    }
}