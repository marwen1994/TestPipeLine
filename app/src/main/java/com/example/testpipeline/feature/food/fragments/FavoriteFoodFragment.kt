package com.example.testpipeline.feature.food.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.testpipeline.data.MainRepo
import com.example.testpipeline.data.retrofit.BuildService.retrofitService
import com.example.testpipeline.databinding.FragmentFavoriteFoodBinding
import com.example.testpipeline.viewmodel.MyViewModelFactory
import com.example.testpipeline.feature.food.MainViewModel
import com.example.testpipeline.feature.food.adapter.FavoriteFoodAdapter
import kotlin.math.abs

class FavoriteFoodFragment : Fragment() {
    lateinit var binding : FragmentFavoriteFoodBinding
    lateinit var viewModel: MainViewModel
    private var adapter: FavoriteFoodAdapter? = null
    private val categoryList: ViewPager2 by lazy { binding.list }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepo(retrofitService))).get(
            MainViewModel::class.java)
        viewModel.retrieveCategory()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.movieList.observe(viewLifecycleOwner) {
        adapter = FavoriteFoodAdapter()
        it.categories?.let { it1 -> adapter?.addList (it1) }
        categoryList.adapter = adapter
    }


        categoryList.clipToPadding = false;
        categoryList.clipChildren = false;
        categoryList.offscreenPageLimit = 3
        categoryList.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER;

        val compositePageTransformer =  CompositePageTransformer();
        compositePageTransformer.addTransformer( MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }

        categoryList.setPageTransformer(compositePageTransformer)
    }


    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?

    ): View {

    binding = FragmentFavoriteFoodBinding.inflate(inflater, container, false)
    return binding.root

    }

    companion object {

        @JvmStatic
        fun newInstance() = FavoriteFoodFragment()
    }
}