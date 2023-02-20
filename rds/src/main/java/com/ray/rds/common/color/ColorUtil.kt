package com.ray.rds.common.color

import android.content.res.TypedArray
import android.view.View
import androidx.annotation.StyleableRes
import androidx.core.content.res.getIntegerOrThrow
import androidx.databinding.BindingConversion

inline fun TypedArray.getMainColorType(
    @StyleableRes index: Int,
    onSuccess: (ColorType) -> Unit
) {
    if (hasValue(index)) {
        ColorType.getColorTypeByIndex(getIntegerOrThrow(index))?.let(onSuccess)
    }
}
