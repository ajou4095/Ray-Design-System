package com.ray.rds.window.loading

import android.content.DialogInterface
import androidx.fragment.app.viewModels
import com.ray.rds.common.eventObserve
import com.ray.rds.databinding.ViewAlertDialogBinding
import com.ray.rds.window.alert.AlertDialogViewEvent
import com.ray.rds.window.alert.AlertDialogViewModel
import com.ray.rds.window.base.BaseDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class LoadingDialogFragment : BaseDialogFragment<ViewAlertDialogBinding>(ViewAlertDialogBinding::inflate) {
    private val viewModel: AlertDialogViewModel by viewModels()

    var onCancel: (() -> Unit)? = null

    var onConfirm: (() -> Unit)? = null

    var onDismiss: (() -> Unit)? = null

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
                    dismissAllowingStateLoss()
                }

                AlertDialogViewEvent.OnConfirm -> {
                    onConfirm?.invoke()
                    dismissAllowingStateLoss()
                }
            }
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        onDismiss?.invoke()
        super.onDismiss(dialog)
    }
}