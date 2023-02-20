package com.ray.rds.view.button

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.ray.rds.R
import com.ray.rds.common.color.ColorSet
import com.ray.rds.common.color.ColorType
import com.ray.rds.common.color.getMainColorType
import com.ray.rds.databinding.ViewConfirmButtonBinding
import com.ray.rds.util.dp
import com.ray.rds.util.getBoolean
import com.ray.rds.util.getInteger
import com.ray.rds.util.getString

class ConfirmButton @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = R.attr.confirmButtonStyle
) : CardView(context, attributeSet, defStyle) {
    private val binding = ViewConfirmButtonBinding.inflate(LayoutInflater.from(context), this, true)

    var text: CharSequence? = null
        get() = binding.content.text
        set(value) {
            field = value
            binding.content.text = field
        }

    var colorSet: ColorSet? = null
        set(value) {
            field = value
            refreshColor()
        }

    var priority: ConfirmButtonPriority? = null
        set(value) {
            field = value
            refreshColor()
        }

    var isLoading: Boolean? = null
        set(value) {
            field = value
            binding.loading.isVisible = isLoading == true
            binding.content.isVisible = isLoading != true
            isEnabled = isLoading != true
        }

    init {
        context.obtainStyledAttributes(attributeSet, R.styleable.ConfirmButton, defStyle, 0).use { attributes ->
            attributes.getString(R.styleable.ConfirmButton_android_text) { text ->
                this.text = text
            }
            attributes.getMainColorType(R.styleable.ConfirmButton_mainColorType) { mainColorType ->
                this.colorSet = mainColorType.getColorSet(context)
            }
            attributes.getInteger(R.styleable.ConfirmButton_priority) { index ->
                this.priority = ConfirmButtonPriority.getPriorityByIndex(index)
            }
            attributes.getBoolean(R.styleable.ConfirmButton_loading) { isLoading ->
                this.isLoading = isLoading
            }
        }
        radius = resources.getDimension(R.dimen.radius_main)
        cardElevation = 0f
        isClickable = true
        isFocusable = true
    }

    private fun refreshColor() {
        val colorSet = colorSet ?: return
        val priority = priority ?: return

        when (priority) {
            ConfirmButtonPriority.Main -> {
                val states = arrayOf(
                    intArrayOf(android.R.attr.state_enabled),
                    intArrayOf(-android.R.attr.state_enabled)
                )

                val colors = intArrayOf(
                    colorSet.bg700,
                    colorSet.bg300
                )

                setCardBackgroundColor(ColorStateList(states, colors))
                binding.content.setTextColor(Color.WHITE)
                binding.loading.indeterminateTintList = ColorStateList.valueOf(Color.WHITE)
            }

            ConfirmButtonPriority.Sub -> {
                val states = arrayOf(
                    intArrayOf(android.R.attr.state_enabled),
                    intArrayOf(-android.R.attr.state_enabled)
                )

                val colors = intArrayOf(
                    colorSet.bg200,
                    colorSet.bg100
                )

                setCardBackgroundColor(ColorStateList(states, colors))
                binding.content.setTextColor(colorSet.fg900)
                binding.loading.indeterminateTintList = ColorStateList.valueOf(
                    ColorType.Gray.getColorSet(context).fg400
                )
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        } else {
            super.onMeasure(
                widthMeasureSpec,
                MeasureSpec.makeMeasureSpec(50.dp.toInt(), MeasureSpec.EXACTLY)
            )
        }
    }
}
