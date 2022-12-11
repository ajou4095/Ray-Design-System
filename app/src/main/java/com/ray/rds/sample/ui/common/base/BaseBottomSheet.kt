package com.ray.rds.sample.ui.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheet<B : ViewDataBinding>(
    private val inflater: (LayoutInflater, ViewGroup?, Boolean) -> B
) : BottomSheetDialogFragment() {
    private var _binding: B? = null

    protected val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflater(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
    }

    protected open fun initView() = Unit

    protected open fun initObserver() = Unit

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun DialogFragment.show() {
        if (
            this@BaseBottomSheet.activity?.isFinishing == false
            && this@BaseBottomSheet.activity?.isDestroyed == false
            && !this@BaseBottomSheet.childFragmentManager.isDestroyed
            && !this@BaseBottomSheet.childFragmentManager.isStateSaved
        ) {
            show(this@BaseBottomSheet.childFragmentManager, javaClass.simpleName)
        }
    }

    protected fun bind(action: B.() -> Unit) {
        binding.action()
    }
}