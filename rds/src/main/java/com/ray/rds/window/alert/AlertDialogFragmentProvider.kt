package com.ray.rds.window.alert

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.SavedStateHandle
import com.ray.rds.common.util.getBooleanOrDefault
import com.ray.rds.common.util.getBundle
import com.ray.rds.common.util.getStringOrDefault

object AlertDialogFragmentProvider {
    private const val BUNDLE = "key_BUNDLE"
    private const val TITLE = "key_TITLE"
    private const val MESSAGE = "key_MESSAGE"
    private const val IS_TWO_BUTTON = "key_IS_TWO_BUTTON"
    private const val CANCEL_MESSAGE = "key_CANCEL_MESSAGE"
    private const val CONFIRM_MESSAGE = "key_CONFIRM_MESSAGE"

    fun makeAlertDialog(
        title: String? = null,
        message: String? = null,
        isTwoButton: Boolean = false,
        cancelMessage: String? = AlertDialogFragmentContract.STRING_CANCEL,
        confirmMessage: String? = AlertDialogFragmentContract.STRING_CONFIRM,
        onCancel: (() -> Unit)? = null,
        onConfirm: (() -> Unit)? = null,
        onDismiss: (() -> Unit)? = null
    ): DialogFragment {
        val args = Bundle().apply {
            putString(TITLE, title)
            putString(MESSAGE, message)
            putBoolean(IS_TWO_BUTTON, isTwoButton)
            putString(CANCEL_MESSAGE, cancelMessage)
            putString(CONFIRM_MESSAGE, confirmMessage)
        }
        val fragment = AlertDialogFragment().apply {
            arguments = Bundle().also {
                it.putBundle(BUNDLE, args)
            }
            // TODO : SavedState Bundle 에 저장되지 않아 상태 저장할 때 유실되는 문제 해결하기.
            /** @see androidx.fragment.app.setFragmentResult **/
            this.onCancel = onCancel
            this.onConfirm = onConfirm
            this.onDismiss = onDismiss
        }
        return fragment
    }

    internal fun getBundle(savedStateHandle: SavedStateHandle): Bundle? {
        return savedStateHandle.getBundle(BUNDLE)
    }

    internal fun getTitle(bundle: Bundle?): String {
        return bundle.getStringOrDefault(TITLE)
    }

    internal fun getMessage(bundle: Bundle?): String {
        return bundle.getStringOrDefault(MESSAGE)
    }

    internal fun isTwoButton(bundle: Bundle?): Boolean {
        return bundle.getBooleanOrDefault(IS_TWO_BUTTON)
    }

    internal fun getCancelMessage(bundle: Bundle?): String {
        return bundle.getStringOrDefault(CANCEL_MESSAGE)
    }

    internal fun getConfirmMessage(bundle: Bundle?): String {
        return bundle.getStringOrDefault(CONFIRM_MESSAGE)
    }
}