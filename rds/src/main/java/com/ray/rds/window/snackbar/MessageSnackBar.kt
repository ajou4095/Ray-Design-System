package com.ray.rds.window.snackbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import androidx.annotation.DrawableRes
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.databinding.DataBindingUtil
import com.ray.rds.R
import com.ray.rds.common.util.orZero
import com.ray.rds.databinding.ViewMessageSnackBarBinding
import com.ray.rds.util.getDisplayHeight
import com.ray.rds.util.getDisplayWidth
import com.ray.rds.util.getLong

class MessageSnackBar private constructor(
    private val parent: ViewGroup,
    private val binding: ViewMessageSnackBarBinding,
    private val anchorView: View? = null
) {
    private val decelerateDuration: Long = binding.root.context.resources.getLong(R.integer.animation_duration)
    private val delayDuration: Long = 2000L
    private val accelerateDuration: Long = binding.root.context.resources.getLong(R.integer.animation_duration)

    fun show() {
        if (parent.children.find { it == binding.root } == null) {
            parent.addView(binding.root)
        }
        animateShowAndHide()
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
        binding.root.animate()
            .setInterpolator(
                MessageSnackBarInterpolator(decelerateDuration, delayDuration, accelerateDuration)
            )
            .setDuration(delayDuration + decelerateDuration + accelerateDuration)
            .y(destinationY)
            .withEndAction { parent.removeView(binding.root) }
            .start()
    }

    companion object {
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

            fun initializeBinding(binding: ViewMessageSnackBarBinding) {
                with(binding) {
                    button.setOnClickListener {
                        listener?.invoke()
                        root.clearAnimation()
                        root.animate()
                            .setInterpolator(DecelerateInterpolator())
                            .setDuration(button.context.resources.getLong(R.integer.animation_duration))
                            .y(getDisplayHeight().toFloat())
                            .withEndAction { parent.removeView(binding.root) }
                            .start()
                    }
                    button.isVisible = listener != null && !buttonText.isNullOrEmpty()
                    icon.isVisible = iconRes != null
                    if (iconRes != null) {
                        icon.setImageResource(iconRes)
                    }
                    title.text = message
                    titleButton.text = buttonText
                }
            }

            val binding: ViewMessageSnackBarBinding = getBinding()
            initializeBinding(binding)

            return MessageSnackBar(
                parent,
                binding,
                anchorView
            )
        }
    }
}
