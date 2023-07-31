package com.azmiradi.channel_app.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Snippet(
    val publishedAt: String? = null,
    val localized: Localized? = null,
    val description: String? = null,
    val title: String? = null,
    val thumbnails: Thumbnails? = null,
    val channelId: String? = null,
    val channelTitle: String? = null,
    val resourceId: ResourceId?= null
)


@Serializable
data class ImageData(
    val url: String? = null
)

@Serializable
data class YouTubeItemData(
    val snippet: Snippet? = null,
    val id: String? = null
)

@Serializable
data class Localized(
    val description: String? = null,
    val title: String? = null
)

@Serializable
data class PageInfo(
    val totalResults: Int? = null,
    val resultsPerPage: Int? = null
)

@Serializable
data class Thumbnails(
    val maxres: ImageData? = null,
)

@Serializable
data class ResourceId(
    val kind: String? = null,
    val videoId: String? = null
)


