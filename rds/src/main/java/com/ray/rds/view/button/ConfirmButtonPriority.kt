package com.ray.rds.view.button

sealed interface ConfirmButtonPriority {
    object Main : ConfirmButtonPriority
    object Sub : ConfirmButtonPriority

    companion object {
        // TODO : attrs 와 index 연결짓기
        fun getPriorityByIndex(index: Int): ConfirmButtonPriority? = when (index) {
            0 -> Main
            1 -> Sub
            else -> null
        }
    }
}