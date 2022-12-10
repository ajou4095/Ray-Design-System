package com.ray.rds.window.alert

import androidx.fragment.app.viewModels
import com.ray.rds.window.base.BaseDialogFragment
import com.ray.rds.common.eventObserve
import com.ray.rds.databinding.ViewAlertDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class AlertDialogFragment : BaseDialogFragment<ViewAlertDialogBinding>(ViewAlertDialogBinding::inflate) {
    private val viewModel: AlertDialogViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initObserver() {
        viewModel.event.eventObserve(viewLifecycleOwner) { event ->
            when (event) {
                AlertDialogViewEvent.OnCancel -> {
                    onCancel?.invoke()
                    //dismiss()
                    dismissAllowingStateLoss()
                }

                AlertDialogViewEvent.OnConfirm -> {
                    onConfirm?.invoke()
                    //dismiss()
                    dismissAllowingStateLoss()
                }
            }
        }
    }
}