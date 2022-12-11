package com.ray.rds.window.alert

internal sealed interface AlertDialogViewEvent {
    object OnCancel : AlertDialogViewEvent
    object OnConfirm : AlertDialogViewEvent
}