package com.ray.rds.window.alert

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.ray.rds.common.getBooleanOrDefault
import com.ray.rds.common.getBundle
import com.ray.rds.common.getStringOrDefault

object AlertDialogFragmentHelper {
    private const val BUNDLE = "key_BUNDLE"
    private const val TITLE = "key_TITLE"
    private const val MESSAGE = "key_MESSAGE"
    private const val IS_TWO_BUTTON = "key_IS_TWO_BUTTON"
    private const val CANCEL_MESSAGE = "key_CANCEL_MESSAGE"
    private const val CONFIRM_MESSAGE = "key_CONFIRM_MESSAGE"

    internal fun newInstance(
        title: String? = null,
        message: String? = null,
        isTwoButton: Boolean = false,
        cancelMessage: String? = AlertDialogFragmentContract.STRING_CANCEL,
        confirmMessage: String? = AlertDialogFragmentContract.STRING_CONFIRM,
        onCancel: (() -> Unit)? = null,
        onConfirm: (() -> Any)? = null
    ): AlertDialogFragment {
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
            this.onCancel = onCancel
            this.onConfirm = onConfirm
        }
        return fragment
    }

    fun getBundle(savedStateHandle: SavedStateHandle): Bundle? {
        return savedStateHandle.getBundle(BUNDLE)
    }

    fun getTitle(bundle: Bundle?): String {
        return bundle.getStringOrDefault(TITLE)
    }

    fun getMessage(bundle: Bundle?): String {
        return bundle.getStringOrDefault(MESSAGE)
    }

    fun isTwoButton(bundle: Bundle?): Boolean {
        return bundle.getBooleanOrDefault(IS_TWO_BUTTON)
    }

    fun getCancelMessage(bundle: Bundle?): String {
        return bundle.getStringOrDefault(CANCEL_MESSAGE)
    }

    fun getConfirmMessage(bundle: Bundle?): String {
        return bundle.getStringOrDefault(CONFIRM_MESSAGE)
    }
}