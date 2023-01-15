package com.ray.rds.common.util

internal fun Double?.orZero(): Double {
    return this ?: 0.0
}

internal fun Float?.orZero(): Float {
    return this ?: 0f
}

internal fun Long?.orZero(): Long {
    return this ?: 0L
}

internal fun Int?.orZero(): Int {
    return this ?: 0
}

internal fun Short?.orZero(): Short {
    return this ?: 0
}

internal fun Byte?.orZero(): Byte {
    return this ?: 0
}
