package com.example.testpipeline.feature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testpipeline.R
import com.example.testpipeline.data.Food

class FoodAdapter () : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    private var categoryList: MutableList<Food> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = categoryList [position]
       Glide.with(holder.img.context).load(food.strCategoryThumb).into(holder.img)
        holder.name.text = food.strCategory
    }

    override fun getItemCount(): Int = categoryList.size

    fun addList(list: MutableList<Food>) {
        this.categoryList.clear()
        this.categoryList = list
        notifyDataSetChanged()
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = itemView.findViewById(R.id.category)
        val name: TextView = itemView.findViewById(R.id.caname)

    }
}
