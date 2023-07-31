package com.azmiradi.channel_app.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.azmiradi.channel_app.data.di.getScreenModel
import com.azmiradi.channel_app.presentation.screens.PlayListItemComposable
import com.azmiradi.channel_app.presentation.screens.TopBar
import com.azmiradi.channel_app.presentation.screens.details.PlayListDetailsScreen

object ChannelPlayListsScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<ChannelPlayListsScreenModel>()
        val state by screenModel.state.collectAsState()

        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar {
                    navigator.pop()
                }
            }) {
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
                        items(it)
                        {
                            PlayListItemComposable(it) {
                                navigator.push(PlayListDetailsScreen(it))
                            }
                        }
                    }
                }
            }
        }
    }
}