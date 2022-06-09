package com.example.calculadoradatabinding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.calculadoradatabinding.databinding.ActivityMainBinding
import com.example.calculadoradatabinding.R
import com.example.calculadoradatabinding.data.CalculatorViewModel

class MainActivity: AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(CalculatorViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
    }
}