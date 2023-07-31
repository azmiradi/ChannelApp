package com.azmiradi.channel_app.data.repository

import com.azmiradi.channel_app.data.network.home.HomeApi
import com.azmiradi.channel_app.domain.entity.BaseResonance
import com.azmiradi.channel_app.domain.entity.YouTubeItemData
import com.azmiradi.channel_app.domain.repository.HomeRepository

class HomeRepositoryImpl(private val homeApi: HomeApi) : HomeRepository {
    override suspend fun getChannelPlayLists(
        part: String,
        channelId: String
    ): BaseResonance<List<YouTubeItemData>> = homeApi.getChannelPlayLists(part, channelId)

    override suspend fun getPlayListVideos(
        part: String,
        playListID: String
    ): BaseResonance<List<YouTubeItemData>> = homeApi.getPlayListVideos(part,playListID)

}