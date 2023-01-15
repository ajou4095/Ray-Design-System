package com.ray.rds.view.group.segment

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import com.ray.rds.ColorType
import com.ray.rds.R
import com.ray.rds.common.util.orZero
import com.ray.rds.util.dp

internal class SegmentItem @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attributeSet, defStyle) {
    var segmentCount: Int? = null
        set(value) {
            field = value
            requestLayout()
        }

    init {
        background = GradientDrawable().apply {
            color = ColorStateList.valueOf(Color.WHITE)
            cornerRadius = resources.getDimension(R.dimen.radius_small)
            setStroke(1.dp.toInt(), ColorType.Gray.colorSet.variant200)
        }
//        cardElevation = 0.dp
//        radius = resources.getDimension(R.dimen.radius_small)
//        setCardBackgroundColor(Color.WHITE)
    }

    // TODO : Segment Group Reference 로 변경
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val fixedSegmentCount = if (segmentCount.orZero() <= 0) 1 else segmentCount ?: 1
        super.onMeasure(
            MeasureSpec.makeMeasureSpec(
                (MeasureSpec.getSize(widthMeasureSpec) - resources.getDimension(R.dimen.spacing_xxs).times(2).toInt()) / fixedSegmentCount,
                MeasureSpec.EXACTLY
            ),
            heightMeasureSpec
        )
    }
}