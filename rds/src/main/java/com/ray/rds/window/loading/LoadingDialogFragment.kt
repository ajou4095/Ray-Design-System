package com.ray.rds.window.loading

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.fragment.app.viewModels
import com.ray.rds.common.base.BaseDialogFragment
import com.ray.rds.databinding.DialogLoadingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class LoadingDialogFragment : BaseDialogFragment<DialogLoadingBinding>(DialogLoadingBinding::inflate) {
    private val viewModel: LoadingDialogViewModel by viewModels()

    override fun initView() {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        isCancelable = false
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initWidth() = Unit
}
