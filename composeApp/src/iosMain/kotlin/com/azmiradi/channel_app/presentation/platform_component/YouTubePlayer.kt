package com.azmiradi.channel_app.presentation.platform_component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import cocoapods.youtube_ios_player_helper.YTPlayerView

@Composable
actual fun YouTubePlayer(videoID: String, modifier: Modifier) {
    UIKitView(
        factory = {
            YTPlayerView()
        },
        update = { view ->
            view.loadWithVideoId(
                videoID,
                playerVars = mapOf(Pair("playsinline", 1))
            )
            view.playVideo()
        },
        modifier = modifier
    )
}
