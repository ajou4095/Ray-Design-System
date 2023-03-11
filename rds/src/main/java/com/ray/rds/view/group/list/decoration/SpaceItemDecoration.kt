package com.ray.rds.view.group.list.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class SpaceItemDecoration(
    private val space: Int,
    @RecyclerView.Orientation
    private val orientation: Int
) : ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.getChildAdapterPosition(view) != parent.adapter?.itemCount?.minus(1)) {
            when (orientation) {
                RecyclerView.VERTICAL -> outRect.bottom = space
                RecyclerView.HORIZONTAL -> outRect.right = space
            }
        }
    }
}
