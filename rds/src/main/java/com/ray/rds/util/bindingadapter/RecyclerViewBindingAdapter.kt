package com.ray.rds.util.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ray.rds.view.group.list.decoration.SpaceItemDecoration

@BindingAdapter("listAdapter_item")
fun RecyclerView.setListAdapterItem(items: List<Any>?) {
    (adapter as? ListAdapter<Any, *>)?.submitList(items)
}

@BindingAdapter("itemDecoration_space")
fun RecyclerView.addSpaceItemDecoration(_space: Float?) {
    val space = _space ?: return
    val orientation = (layoutManager as? LinearLayoutManager)?.orientation ?: return

    for (i in 0 until itemDecorationCount) {
        if (getItemDecorationAt(i) is SpaceItemDecoration) return
    }
    addItemDecoration(
        SpaceItemDecoration(
            space = space.toInt(),
            orientation = orientation
        )
    )
}
