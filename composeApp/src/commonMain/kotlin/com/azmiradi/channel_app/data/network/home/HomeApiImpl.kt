package com.azmiradi.channel_app.data.network.home

import ChannelApp.composeApp.BuildConfig.API_KEY
import com.azmiradi.channel_app.data.network.client
import com.azmiradi.channel_app.data.network.newsEndPoint
import com.azmiradi.channel_app.domain.entity.BaseResonance
import com.azmiradi.channel_app.domain.entity.YouTubeItemData
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers


class HomeApiImpl : HomeApi {

    override suspend fun getChannelPlayLists(
        part: String,
        channelId: String
    ): BaseResonance<List<YouTubeItemData>> {
        return client.get {
            headers {
                newsEndPoint("youtube/v3/playlists?part=$part&channelId=$channelId&key=$API_KEY")
            }
        }.body()
    }

    override suspend fun getPlayListVideos(
        part: String,
        playListID: String
    ): BaseResonance<List<YouTubeItemData>> {
        return client.get {
            headers {
                newsEndPoint("youtube/v3/playlistItems?part=$part&playlistId=$playListID&key=$API_KEY")
            }
        }.body()
    }
}

