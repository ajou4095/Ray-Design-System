package com.ray.rds.window.snackbar

import android.view.animation.BaseInterpolator
import android.view.animation.DecelerateInterpolator

class MessageSnackBarInterpolator(
    decelerateDuration: Long,
    delayDuration: Long,
    accelerateDuration: Long
) : BaseInterpolator() {
    private val decelerateSection: Float = decelerateDuration.toFloat() / (decelerateDuration + delayDuration + accelerateDuration)

    private val delaySection: Float =
        (decelerateDuration + delayDuration).toFloat() / (decelerateDuration + delayDuration + accelerateDuration)

    private val decelerateInterpolator = DecelerateInterpolator()

    override fun getInterpolation(input: Float): Float {
        val result = when {
            input < decelerateSection -> {
                decelerateInterpolator.getInterpolation(input / decelerateSection)
            }

            input < delaySection -> {
                1f
            }

            else -> {
                decelerateInterpolator.getInterpolation(1f - (input - delaySection) / (1f - delaySection))
            }
        }
        return result
    }
}
