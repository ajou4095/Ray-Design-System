package com.ray.rds.common.util

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle

internal fun SavedStateHandle.getBundle(
    key: String
): Bundle? {
    return get<Bundle>(key)
}

internal fun Bundle?.getBooleanOrDefault(
    key: String,
    defaultValue: Boolean? = null
): Boolean {
    return (this?.getBoolean(key) ?: defaultValue).orFalse()
}

internal fun Bundle?.getByteOrDefault(
    key: String,
    defaultValue: Byte? = null
): Byte {
    return (this?.getByte(key) ?: defaultValue).orZero()
}

internal fun Bundle?.getCharOrDefault(
    key: String,
    defaultValue: Char? = null
): Char {
    return (this?.getChar(key) ?: defaultValue).orEmpty()
}

internal fun Bundle?.getDoubleOrDefault(
    key: String,
    defaultValue: Double? = null
): Double {
    return (this?.getDouble(key) ?: defaultValue).orZero()
}

internal fun Bundle?.getFloatOrDefault(
    key: String,
    defaultValue: Float? = null
): Float {
    return (this?.getFloat(key) ?: defaultValue).orZero()
}

internal fun Bundle?.getIntOrDefault(
    key: String,
    defaultValue: Int? = null
): Int {
    return (this?.getInt(key) ?: defaultValue).orZero()
}

internal fun Bundle?.getLongOrDefault(
    key: String,
    defaultValue: Long? = null
): Long {
    return (this?.getLong(key) ?: defaultValue).orZero()
}

internal fun Bundle?.getShortOrDefault(
    key: String,
    defaultValue: Short? = null
): Short {
    return (this?.getShort(key) ?: defaultValue).orZero()
}

internal fun Bundle?.getStringOrDefault(
    key: String,
    defaultValue: String? = null
): String {
    return (this?.getString(key) ?: defaultValue).orEmpty()
}