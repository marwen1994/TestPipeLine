package com.example.testpipeline.feature.food.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testpipeline.R
import com.example.testpipeline.data.entities.Food

class FavoriteFoodAdapter : RecyclerView.Adapter<FavoriteFoodAdapter.ViewHolder>() {
    private var categoryList: MutableList<Food> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.favorite_row_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = categoryList [position]
        Glide.with(holder.img.context).load(food.strCategoryThumb).into(holder.img)
    }

    override fun getItemCount(): Int = categoryList.size

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: MutableList<Food>) {
        this.categoryList.clear()
        this.categoryList = list
        notifyDataSetChanged()
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = itemView.findViewById(R.id.category)
    }
}