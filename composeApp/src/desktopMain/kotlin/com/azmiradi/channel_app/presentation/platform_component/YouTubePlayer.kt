package com.azmiradi.channel_app.presentation.platform_component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.azmiradi.channel_app.openUrl

@Composable
actual fun YouTubePlayer(videoID: String, modifier: Modifier) {
    val url = "https://www.youtube.com/watch?v=$videoID"
    openUrl(url)
}