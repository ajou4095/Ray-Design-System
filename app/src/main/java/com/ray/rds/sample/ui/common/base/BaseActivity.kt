package com.ray.rds.sample.ui.common.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment

abstract class BaseActivity<B : ViewDataBinding>(
    private val inflater: (LayoutInflater) -> B
) : AppCompatActivity() {
    protected lateinit var binding: B
        private set

    val tag: String
        get() = this.javaClass.simpleName ?: "BaseActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflater(layoutInflater)
        setContentView(binding.root)
    }

    protected open fun initView() = Unit

    protected open fun initObserver() = Unit

    fun DialogFragment.show() {
        if (
            !this@BaseActivity.isFinishing
            && !this@BaseActivity.isDestroyed
            && !this@BaseActivity.supportFragmentManager.isDestroyed
            && !this@BaseActivity.supportFragmentManager.isStateSaved
        ) {
            show(this@BaseActivity.supportFragmentManager, javaClass.simpleName)
        }
    }

    protected fun bind(action: B.() -> Unit) {
        binding.action()
    }
}