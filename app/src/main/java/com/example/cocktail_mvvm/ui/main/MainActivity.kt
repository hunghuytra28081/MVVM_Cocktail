package com.example.cocktail_mvvm.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.cocktail_mvvm.R
import com.example.cocktail_mvvm.databinding.ActivityMainBinding
import com.example.cocktail_mvvm.ui.main.adapter.CocktailAdapter
import com.example.cocktail_mvvm.ui.main.viewmodel.CocktailViewModel
import com.example.cocktail_mvvm.utils.Status
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val cocktailViewModel by viewModel<CocktailViewModel>()
    private val cocktailAdapter by lazy { CocktailAdapter() }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewmodel = cocktailViewModel
        initViews()
        initData()
    }

    private fun initViews() {
        binding.cocktailAdapter = cocktailAdapter
    }

    private fun initData() {
        cocktailViewModel.cocktails.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    cocktailAdapter.setData(it.data)
                }
                Status.ERROR -> {
                    Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
