package com.azmiradi.channel_app

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import com.azmiradi.channel_app.presentation.screens.home.ChannelPlayListsScreen
import com.azmiradi.channel_app.presentation.theme.AppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun App() = AppTheme(useDarkTheme = false) {
    BottomSheetNavigator {
        Navigator(ChannelPlayListsScreen)
    }
}


internal expect fun openUrl(url: String?)