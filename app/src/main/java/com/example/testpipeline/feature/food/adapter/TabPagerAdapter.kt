package com.example.testpipeline.feature.food.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testpipeline.feature.food.fragments.CategoryFoodFragment
import com.example.testpipeline.feature.food.fragments.FavoriteFoodFragment
import com.example.testpipeline.feature.profile.ProfileFragment

class TabPagerAdapter (activity: FragmentActivity , private val tabCount : Int):FragmentStateAdapter (activity) {
    override fun getItemCount(): Int = tabCount

    override fun createFragment(position: Int): Fragment {
       return when (position) {
           0 -> CategoryFoodFragment()
           1 -> FavoriteFoodFragment()
           2 -> ProfileFragment()
           else -> CategoryFoodFragment()

       }
    }
}