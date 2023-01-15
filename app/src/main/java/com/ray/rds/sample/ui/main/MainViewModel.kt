package com.ray.rds.sample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ray.rds.sample.ui.common.util.event.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val _state = MutableLiveData<Event<MainViewState>>()
    val state: LiveData<Event<MainViewState>>
        get() = _state

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _segments = MutableLiveData(emptyList<String>())
    val segments: LiveData<List<String>>
        get() = _segments

    val segmentPosition = MutableLiveData<Int>(1)

    init {
        viewModelScope.launch {
            delay(1000)
            _segments.value = listOf(
                "Item 1",
                "Item 2",
                "Item 3"
            )
        }
    }

    fun onSegmentControlClick(position: Int) {
        Timber.d("onSegmentControlClick : $position")
    }

    fun onConfirm() {
        _state.value = Event(MainViewState.Confirm)
    }
}