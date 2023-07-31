package com.azmiradi.channel_app.presentation.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.azmiradi.channel_app.MR
import com.azmiradi.channel_app.data.di.getScreenModel
import com.azmiradi.channel_app.domain.entity.YouTubeItemData
import com.azmiradi.channel_app.presentation.screens.PlayListItemComposable
import com.azmiradi.channel_app.presentation.screens.TopBar
import com.azmiradi.channel_app.presentation.screens.video_details.VideoDetailsScreen
import com.seiko.imageloader.rememberImagePainter
import dev.icerock.moko.resources.compose.painterResource

data class PlayListDetailsScreen(private val playListItem: YouTubeItemData) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<PlayListVideosScreenModel>()
        val state by screenModel.state.collectAsState()
        LaunchedEffect(Unit) {
            playListItem.id?.let {
                screenModel.getPlayListVideos(playListID = it)
            }
        }
        val painter = rememberImagePainter(
            url = playListItem.snippet?.thumbnails?.maxres?.url ?: "",
            placeholderPainter = {
                painterResource(MR.images.image_loading)
            },
            errorPainter = {
                painterResource(MR.images.image_error)
            }
        )

        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar {
                    navigator.pop()
                }
            }) {
            BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier.height(maxHeight / 3)
                        .fillMaxWidth(),
                    painter = painter,
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                Card(
                    Modifier
                        .fillMaxSize()
                        .padding(top = (maxHeight / 4)),
                    shape = RoundedCornerShape(
                        topEnd = 30.dp,
                        topStart = 30.dp
                    ),
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                            .padding(10.dp)
                    ) {
                        Spacer(Modifier.height(10.dp))
                        Text(
                            playListItem.snippet?.channelTitle ?: "---",
                            modifier = Modifier.clip(RoundedCornerShape(10.dp))
                                .background(Color.LightGray)
                                .padding(
                                    start = 10.dp, end = 10.dp,
                                    top = 5.dp, bottom = 5.dp
                                ),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(10.dp))

                        Text(
                            playListItem.snippet?.title ?: "---",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Box(Modifier.fillMaxSize()) {
                            if (state.isLoading) {
                                CircularProgressIndicator(
                                    modifier = Modifier.align(Alignment.Center),
                                    color = Color.Black
                                )
                            }

                            state.data?.items?.let {
                                LazyColumn(
                                    modifier = Modifier.fillMaxSize()
                                        .padding(10.dp),
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    item {
                                        Spacer(Modifier.height(10.dp))
                                        Text(
                                            playListItem.snippet?.description ?: "---",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Normal,
                                        )
                                    }
                                    items(it)
                                    { videoData ->
                                        PlayListItemComposable(videoData) {
                                            videoData.snippet?.resourceId?.videoId?.let {
                                                navigator.push(VideoDetailsScreen(videoData))
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}