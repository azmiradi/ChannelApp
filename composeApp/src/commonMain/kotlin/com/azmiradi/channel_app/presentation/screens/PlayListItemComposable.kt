package com.azmiradi.channel_app.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azmiradi.channel_app.MR
import com.azmiradi.channel_app.domain.entity.YouTubeItemData
import com.seiko.imageloader.rememberImagePainter
import dev.icerock.moko.resources.compose.fontFamilyResource
import dev.icerock.moko.resources.compose.painterResource

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun PlayListItemComposable(
    playListItem: YouTubeItemData,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(150.dp),
        elevation = 10.dp,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(Modifier.fillMaxSize()) {
            val painter = rememberImagePainter(
                url = playListItem.snippet?.thumbnails?.maxres?.url ?: "",
//                placeholderPainter = {
//                    painterResource(MR.images.image_loading)
//                },
//                errorPainter = {
//                    painterResource(MR.images.image_error)
//                }
            )

            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(10.dp)
                    .background(Color.White.copy(0.7f))
                    .clip(RoundedCornerShape(10.dp))
            ) {

                Text(
                    playListItem.snippet?.title ?: "----",
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = fontFamilyResource(MR.fonts.messiri.messiri),
                    color = Color.Black
                )
            }

        }
    }
}