package com.ray.rds.common.util

internal fun Char?.orEmpty(): Char {
    return this ?: Char.MIN_VALUE
}