package com.azmiradi.channel_app.domain.entity

import kotlinx.serialization.Serializable


@Serializable
data class ArticlesResponse(
    val totalArticles: Int? = null,
    val articles: List<Article?>? = null,
    val status: String? = null
)

@Serializable
data class Source(
    val name: String? = null,
    val url: String? = null
)

@Serializable
data class Article(
    val title: String? = null,
    val description: String? = null,
    val content: String? = null,
    val url: String? = null,
    val image: String? = null,
    val publishedAt: String? = null,
    val source: Source? = null,
)
