package com.azmiradi.channel_app.data.network.home

import com.azmiradi.channel_app.domain.entity.BaseResonance
import com.azmiradi.channel_app.domain.entity.YouTubeItemData

interface HomeApi {
    suspend fun getChannelPlayLists(
        part: String = "snippet",
        channelId: String = "UC20hURwH-gjFQ5ZTV_MsdRA"
    ): BaseResonance<List<YouTubeItemData>>

    suspend fun getPlayListVideos(
        part: String = "snippet",
        playListID: String
    ): BaseResonance<List<YouTubeItemData>>
}