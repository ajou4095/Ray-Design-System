package com.ray.rds.common.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.ray.rds.common.util.event.Event
import com.ray.rds.common.util.event.EventObserver

internal val LiveData<Boolean>.valueOrDefault: Boolean
    get() = value ?: false

internal val LiveData<Byte>.valueOrDefault: Byte
    get() = value ?: 0

internal val LiveData<Char>.valueOrDefault: Char
    get() = value ?: Char.MIN_VALUE

internal val LiveData<Double>.valueOrDefault: Double
    get() = value ?: 0.0

internal val LiveData<Float>.valueOrDefault: Float
    get() = value ?: 0f

internal val LiveData<Int>.valueOrDefault: Int
    get() = value ?: 0

internal val LiveData<Long>.valueOrDefault: Long
    get() = value ?: 0L

internal val LiveData<Short>.valueOrDefault: Short
    get() = value ?: 0

internal val LiveData<String>.valueOrDefault: String
    get() = value ?: ""

internal fun <T> LiveData<Event<T>>.eventObserve(owner: LifecycleOwner, onEventUnhandledContent: (T) -> Unit) {
    this.observe(owner, EventObserver(onEventUnhandledContent))
}