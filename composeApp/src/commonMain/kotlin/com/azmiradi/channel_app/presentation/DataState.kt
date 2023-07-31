package com.azmiradi.channel_app.presentation

data class DataState<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val error: String = "",
)
