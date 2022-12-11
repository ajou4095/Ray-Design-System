package com.ray.rds.window.alert

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ray.rds.common.event.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class AlertDialogViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val bundle: Bundle? by lazy {
        AlertDialogFragmentProvider.getBundle(savedStateHandle)
    }

    val title: String by lazy {
        AlertDialogFragmentProvider.getTitle(bundle)
    }

    val message: String by lazy {
        AlertDialogFragmentProvider.getMessage(bundle)
    }

    val isTwoButton: Boolean by lazy {
        AlertDialogFragmentProvider.isTwoButton(bundle)
    }

    val cancelMessage: String by lazy {
        AlertDialogFragmentProvider.getCancelMessage(bundle)
    }

    val confirmMessage: String by lazy {
        AlertDialogFragmentProvider.getConfirmMessage(bundle)
    }

    private val _event = MutableLiveData<Event<AlertDialogViewEvent>>()
    val event: LiveData<Event<AlertDialogViewEvent>>
        get() = _event

    fun onCancel() {
        _event.value = Event(AlertDialogViewEvent.OnCancel)
    }

    fun onConfirm() {
        _event.value = Event(AlertDialogViewEvent.OnConfirm)
    }
}