package com.ray.rds.window.loading

import androidx.fragment.app.DialogFragment

object LoadingDialogFragmentProvider {
    fun makeLoadingDialog(): DialogFragment {
        return LoadingDialogFragment()
    }
}