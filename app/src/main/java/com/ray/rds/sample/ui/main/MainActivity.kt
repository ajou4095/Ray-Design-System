package com.ray.rds.sample.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import com.ray.rds.common.eventObserve
import com.ray.rds.sample.databinding.ActivityMainBinding
import com.ray.rds.sample.ui.common.base.BaseActivity
import com.ray.rds.window.alert.AlertDialogFragmentProvider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
                    viewModel.viewModelScope.launch {
                        withContext(Dispatchers.Main) {
                            showLoading()
                        }
                        delay(1000)
                        withContext(Dispatchers.Main) {
                            hideDialog()
                            AlertDialogFragmentProvider.makeAlertDialog(
                                title = "Internal Server Error",
                                message = "404 has been occurred"
                            ).show()
                        }
                    }
                }
            }
        }
    }
}