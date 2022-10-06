package com.example.testpipeline.feature.food

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.testpipeline.data.retrofit.BuildService
import com.example.testpipeline.data.MainRepo
import com.example.testpipeline.databinding.ActivityMainBinding
import com.example.testpipeline.viewmodel.MyViewModelFactory
import com.example.testpipeline.feature.food.adapter.TabPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = BuildService.getInstance()
    private val tableLayout: TabLayout by lazy { binding.tableLayout }
    private val pager: ViewPager2 by lazy { binding.pager }



    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepo(retrofitService))).get(
            MainViewModel::class.java)
        setTabLayout()
    }

    private fun setTabLayout() {
      val adapter = TabPagerAdapter(this, tableLayout.tabCount)
        pager.adapter = adapter
        pager.isUserInputEnabled = false
        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tableLayout.selectTab(tableLayout.getTabAt(position))
            }
        })
        tableLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
            pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("tab","tab")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("tab","tab")
            }

        })
    }
}