package com.azmiradi.channel_app.presentation.screens.video_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.azmiradi.channel_app.domain.entity.YouTubeItemData
import com.azmiradi.channel_app.presentation.platform_component.YouTubePlayer
import com.azmiradi.channel_app.presentation.screens.TopBar

data class VideoDetailsScreen(val videoItem: YouTubeItemData) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar {
                    navigator.pop()
                }
            }) {
            Column(modifier = Modifier.fillMaxSize()) {
                YouTubePlayer(
                    videoID = videoItem.snippet?.resourceId?.videoId ?: "",
                    Modifier.fillMaxWidth().height(250.dp).background(Color.Black)
                )
                Spacer(Modifier.height(15.dp))
                Text(
                    videoItem.snippet?.channelTitle ?: "---",
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                        .padding(
                            start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp
                        ),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(10.dp))

                Text(
                    videoItem.snippet?.title ?: "---",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )

                Spacer(Modifier.height(10.dp))
                Text(
                    videoItem.snippet?.description ?: "---",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                        .verticalScroll(rememberScrollState())
                )

            }
        }


    }
}
