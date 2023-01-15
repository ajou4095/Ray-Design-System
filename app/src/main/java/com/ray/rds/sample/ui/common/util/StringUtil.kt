package com.ray.rds.sample.ui.common.util

fun Char?.orEmpty(): Char {
    return this ?: Char.MIN_VALUE
}