package com.azmiradi.channel_app.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class BaseResonance <T> (
    val nextPageToken: String? = null,
    val pageInfo: PageInfo? = null,
    val items: T? = null
)