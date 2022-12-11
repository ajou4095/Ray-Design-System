package com.ray.rds.sample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ray.rds.common.event.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    val _state = MutableLiveData<Event<MainViewState>>()
    val state: LiveData<Event<MainViewState>>
        get() = _state

    fun onConfirm() {
        _state.value = Event(MainViewState.Confirm)
    }
}