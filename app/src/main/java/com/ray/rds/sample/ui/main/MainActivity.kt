package com.ray.rds.sample.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.ray.rds.common.eventObserve
import com.ray.rds.sample.databinding.ActivityMainBinding
import com.ray.rds.sample.ui.common.base.BaseActivity
import com.ray.rds.window.alert.AlertDialogFragmentProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initObserver()
    }

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = this@MainActivity
        }
    }

    override fun initObserver() {
        viewModel.state.eventObserve(this@MainActivity) { state ->
            when (state) {
                MainViewState.Confirm -> {
                    AlertDialogFragmentProvider.makeAlertDialog(
                        title = "Internal Server Error",
                        message = "404 has been occurred"
                    ).show()
                }
            }
        }
    }
}