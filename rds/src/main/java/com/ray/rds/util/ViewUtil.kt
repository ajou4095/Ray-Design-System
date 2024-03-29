package com.ray.rds.util

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.content.res.TypedArray
import android.util.TypedValue
import android.view.View
import androidx.annotation.IntegerRes
import androidx.annotation.StyleableRes
import androidx.core.content.res.getBooleanOrThrow
import androidx.core.content.res.getFloatOrThrow
import androidx.core.content.res.getIntegerOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import androidx.core.content.res.getTextOrThrow
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.findViewTreeLifecycleOwner
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val Int.dp: Float
    get() {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            Resources.getSystem().displayMetrics
        )
    }

fun getDisplayWidth() = Resources.getSystem().displayMetrics.widthPixels

fun getDisplayHeight() = Resources.getSystem().displayMetrics.heightPixels

val ViewDataBinding.context: Context
    get() = root.context

inline fun TypedArray.getText(
    @StyleableRes index: Int,
    onSuccess: (CharSequence) -> Unit
) {
    if (hasValue(index)) {
        val value = getTextOrThrow(index)
        onSuccess(value)
    }
}

inline fun TypedArray.getString(
    @StyleableRes index: Int,
    onSuccess: (String) -> Unit
) {
    if (hasValue(index)) {
        val value = getStringOrThrow(index)
        onSuccess(value)
    }
}

fun TypedArray.getIntegerOrNull(@StyleableRes index: Int): Int? {
    return if (hasValue(index)) {
        getIntegerOrThrow(index)
    } else {
        null
    }
}

inline fun TypedArray.getInteger(
    @StyleableRes index: Int,
    onSuccess: (Int) -> Unit
) {
    if (hasValue(index)) {
        val value = getIntegerOrThrow(index)
        onSuccess(value)
    }
}

fun TypedArray.getBooleanOrNull(@StyleableRes index: Int): Boolean? {
    return if (hasValue(index)) {
        getBooleanOrThrow(index)
    } else {
        null
    }
}

inline fun TypedArray.getBoolean(
    @StyleableRes index: Int,
    onSuccess: (Boolean) -> Unit
) {
    if (hasValue(index)) {
        val value = getBooleanOrThrow(index)
        onSuccess(value)
    }
}

fun TypedArray.getFloatOrNull(@StyleableRes index: Int): Float? {
    return if (hasValue(index)) {
        getFloatOrThrow(index)
    } else {
        null
    }
}

inline fun TypedArray.getFloat(
    @StyleableRes index: Int,
    onSuccess: (Float) -> Unit
) {
    if (hasValue(index)) {
        val value = getFloatOrThrow(index)
        onSuccess(value)
    }
}

fun TypedArray.getLong(
    @StyleableRes index: Int,
    defValue: Long
): Long {
    return getLongOrNull(index) ?: defValue
}

fun TypedArray.getLongOrNull(@StyleableRes index: Int): Long? {
    return getIntegerOrNull(index)?.toLong()
}

inline fun TypedArray.getLong(
    @StyleableRes index: Int,
    onSuccess: (Long) -> Unit
) {
    getInteger(index) {
        onSuccess(it.toLong())
    }
}

inline fun TypedArray.getResourceId(
    @StyleableRes index: Int,
    onSuccess: (Int) -> Unit
) {
    if (hasValue(index)) {
        val value = getResourceIdOrThrow(index)
        onSuccess(value)
    }
}

inline fun TypedArray.getResourceId(
    @StyleableRes index: Int,
    onFailure: () -> Unit,
    onSuccess: (Int) -> Unit
) {
    if (hasValue(index)) {
        val value = getResourceIdOrThrow(index)
        onSuccess(value)
    } else {
        onFailure()
    }
}

fun Resources.getLong(
    @IntegerRes id: Int
): Long {
    return getInteger(id).toLong()
}

fun makeColorStateList(vararg colorStateList: Pair<IntArray, Int>) = ColorStateList(
    colorStateList.map { it.first }.toTypedArray(),
    colorStateList.map { it.second }.toTypedArray().toIntArray()
)

/**
 *
 * Safely run some delayed tasks in a view as they will be tied to the lifecycle.
 *
 * @param duration delay task in milliseconds
 * @param dispatcher CoroutineDispatcher, defaults to Dispatchers.Main as view work is done on Main thread
 * @param block the block of work to be done
 *
 * example:
 *
 * view.delayOnLifeCycle(500L) {
 *   // Do something
 *  }
 *
 * */
fun View.delayOnLifecycle(
    duration: Long,
    dispatcher: CoroutineDispatcher = Dispatchers.Main,
    block: () -> Unit
): Job? = findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
    lifecycleOwner.lifecycle.coroutineScope.launch(dispatcher) {
        delay(duration)
        block()
    }
}
