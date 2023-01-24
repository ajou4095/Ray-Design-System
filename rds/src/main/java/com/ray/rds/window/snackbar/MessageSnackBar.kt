package com.ray.rds.window.snackbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.annotation.DrawableRes
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.databinding.DataBindingUtil
import com.ray.rds.UiCommonContract
import com.ray.rds.common.util.orZero
import com.ray.rds.databinding.ViewMessageSnackBarBinding
import com.ray.rds.util.getDisplayHeight
import com.ray.rds.util.getDisplayWidth

class MessageSnackBar private constructor(
    private val parent: ViewGroup,
    private val binding: ViewMessageSnackBarBinding,
    private val anchorView: View? = null
) {

    fun show() {
        if (parent.children.find { it == binding.root } == null) {
            parent.addView(binding.root)
        }
        animateShowAndHide()
    }

    private fun setOnButtonClickListener(onClick: (() -> Unit)?) {
        binding.button.setOnClickListener {
            onClick?.invoke()
            binding.root.animate()
                .setInterpolator(AccelerateInterpolator())
                .setDuration(DURATION_DISAPPEAR)
                .y(getDisplayHeight().toFloat())
                .withEndAction { parent.removeView(binding.root) }
                .start()
        }
    }

    private fun animateShowAndHide() {
        binding.root.measure(
            View.MeasureSpec.makeMeasureSpec(
                getDisplayWidth() - binding.root.marginStart.orZero() - binding.root.marginEnd.orZero(),
                View.MeasureSpec.EXACTLY
            ),
            View.MeasureSpec.UNSPECIFIED
        )
        val destinationBottom = anchorView?.let { anchorView ->
            IntArray(2).let { array ->
                anchorView.getLocationInWindow(array)
                array[1]
            }
        }?.minus(
            IntArray(2).let { array ->
                parent.getLocationInWindow(array)
                array[1]
            }
        ) ?: getDisplayHeight()
        val destinationY: Float = (destinationBottom - binding.root.marginBottom.orZero() - binding.root.measuredHeight).toFloat()
        binding.root.y = getDisplayHeight().toFloat()
        binding.root.clearAnimation()

        val delayDuration = if (binding.button.isVisible) {
            DURATION_DELAY_WITH_BUTTON
        } else {
            DURATION_DELAY_WITHOUT_BUTTON
        }

        binding.root.animate()
            .setInterpolator(
                MessageSnackBarInterpolator(DURATION_APPEAR, delayDuration, DURATION_DISAPPEAR)
            )
            .setDuration(DURATION_APPEAR + delayDuration + DURATION_DISAPPEAR)
            .y(destinationY)
            .withEndAction { parent.removeView(binding.root) }
            .start()
    }

    companion object {
        private const val DURATION_APPEAR: Long = UiCommonContract.ANIMATION_DURATION
        private const val DURATION_DELAY_WITHOUT_BUTTON: Long = 2000L
        private const val DURATION_DELAY_WITH_BUTTON: Long = 5000L
        private const val DURATION_DISAPPEAR: Long = UiCommonContract.ANIMATION_DURATION

        fun make(
            parent: ViewGroup,
            anchorView: View? = null,
            message: String? = null,
            @DrawableRes iconRes: Int? = null,
            buttonText: String? = null,
            listener: (() -> Unit)? = null
        ): MessageSnackBar {
            fun getBinding(): ViewMessageSnackBarBinding {
                parent.children.forEach {
                    return DataBindingUtil.getBinding<ViewMessageSnackBarBinding?>(it) ?: return@forEach
                }
                return ViewMessageSnackBarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }

            fun ViewMessageSnackBarBinding.initialize(): ViewMessageSnackBarBinding {
                button.isVisible = listener != null && !buttonText.isNullOrEmpty()
                icon.isVisible = iconRes != null
                if (iconRes != null) {
                    icon.setImageResource(iconRes)
                }
                title.text = message
                titleButton.text = buttonText
                return this
            }

            return MessageSnackBar(
                parent,
                getBinding().initialize(),
                anchorView
            ).apply {
                setOnButtonClickListener(listener)
            }
        }
    }
}
