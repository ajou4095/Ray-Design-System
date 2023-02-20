package com.ray.rds.view.group.segment

import android.animation.ValueAnimator
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.core.view.doOnPreDraw
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods
import com.ray.rds.OnItemClickListener
import com.ray.rds.R
import com.ray.rds.common.color.ColorType
import com.ray.rds.common.util.orZero
import com.ray.rds.databinding.ViewSegmentChildBinding
import com.ray.rds.databinding.ViewSegmentGroupBinding
import com.ray.rds.util.dp
import com.ray.rds.util.getLong
import com.ray.rds.util.getResourceId
import com.ray.rds.util.makeColorStateList


@BindingAdapter("positionAttrChanged")
fun SegmentControl.setPositionAttrChangedListener(
    listener: InverseBindingListener?
) {
    positionAttrChanged = listener
}

@InverseBindingMethods(
    value = [
        InverseBindingMethod(
            type = SegmentControl::class,
            attribute = "position"
        )
    ]
)
class SegmentControl @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attributeSet, defStyle) {
    private val binding = ViewSegmentGroupBinding.inflate(LayoutInflater.from(context), this, true)

    private val grayColorSet = ColorType.Gray.getColorSet(context)

    var segments: List<String>? = null
        set(value) {
            field = value
            refreshSegmentChildren()
        }

    var position: Int? = null
        set(value) {
            if (field == value) return
            field = value
            animateSegmentItem()
        }

    var onItemClick: OnItemClickListener? = null

    internal var positionAttrChanged: InverseBindingListener? = null

    private var segmentItemAnimator: ValueAnimator? = null

    init {
        context.obtainStyledAttributes(attributeSet, R.styleable.SegmentControl).use { attributes ->
            attributes.getResourceId(
                R.styleable.SegmentControl_segments,
                onFailure = {
                    this.segments = listOf("")
                },
                onSuccess = { resId ->
                    this.segments = resources.getStringArray(resId).toList()
                }
            )
            this.position = attributes.getInteger(R.styleable.SegmentControl_position, 0)
        }
        background = GradientDrawable().apply {
            color = ColorStateList.valueOf(grayColorSet.bg200)
            setStroke(1.dp.toInt(), grayColorSet.bg400)
            cornerRadius = resources.getDimension(R.dimen.radius_main)
        }
    }

    private fun refreshSegmentChildren() {
        binding.containerSegmentChildren.removeAllViews()
        segments?.forEachIndexed { index, segment ->
            val childBinding = ViewSegmentChildBinding.inflate(LayoutInflater.from(context), binding.containerSegmentChildren, false)
            binding.containerSegmentChildren.addView(
                childBinding.root,
                LinearLayoutCompat.LayoutParams(0, LinearLayoutCompat.LayoutParams.MATCH_PARENT, 1f)
            )
            childBinding.root.setOnClickListener {
                position = index
                onItemClick?.onClick(index)
                positionAttrChanged?.onChange()
            }
            childBinding.text.text = segment
            childBinding.text.setTextColor(
                makeColorStateList(
                    intArrayOf(-android.R.attr.state_selected) to grayColorSet.fg400,
                    intArrayOf(android.R.attr.state_selected) to grayColorSet.fg900,
                )
            )
        }
        binding.segmentItem.segmentCount = segments?.size.orZero()
        doOnPreDraw { animateSegmentItem() }
    }

    private fun animateSegmentItem() {
        binding.containerSegmentChildren.children.forEachIndexed { childIndex, child ->
            child.isSelected = childIndex == position
            child.isClickable = childIndex != position
        }
        if (
            segmentItemAnimator != null &&
            segmentItemAnimator?.isRunning == true
        ) {
            segmentItemAnimator?.cancel()
            segmentItemAnimator = null
        }
        segmentItemAnimator = ValueAnimator.ofFloat(
            binding.segmentItem.x,
            binding.containerSegmentChildren.x + binding.containerSegmentChildren.getChildAt(position.orZero())?.x.orZero()
        ).apply {
            interpolator = DecelerateInterpolator()
            duration = resources.getLong(R.integer.animation_duration)
            addUpdateListener {
                binding.segmentItem.x = (it.animatedValue as? Float).orZero()
            }
            start()
        }
    }
}
