package com.ray.rds.common.util

internal fun Boolean?.orFalse(): Boolean {
    return this ?: false
}

internal fun Boolean?.orTrue(): Boolean {
    return this ?: true
}