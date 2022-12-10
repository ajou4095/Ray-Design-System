package com.ray.rds.sample.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.ray.rds.sample.databinding.ActivityMainBinding
import com.ray.rds.sample.ui.common.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = this@MainActivity
        }
    }
}