package com.ray.rds.common

fun Char?.orEmpty(): Char {
    return this ?: Char.MIN_VALUE
}