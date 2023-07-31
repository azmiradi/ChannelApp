package com.azmiradi.channel_app.presentation.screens.home

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.azmiradi.channel_app.domain.Resource
import com.azmiradi.channel_app.domain.entity.BaseResonance
import com.azmiradi.channel_app.domain.entity.YouTubeItemData
import com.azmiradi.channel_app.domain.use_case.GetChannelPlayListsUseCase
import com.azmiradi.channel_app.presentation.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ChannelPlayListsScreenModel(private val getChannelPlayListsUseCase: GetChannelPlayListsUseCase) :
    StateScreenModel<DataState<BaseResonance<List<YouTubeItemData>>>>(initialState = DataState()) {

    init {
        getChannelPlayLists()
    }
    private fun getChannelPlayLists() {
        getChannelPlayListsUseCase().onEach {
            when (it) {
                is Resource.Error -> {
                    mutableState.value = DataState(error = it.message ?: "")
                }

                is Resource.Loading -> {
                    mutableState.value = DataState(isLoading = true)
                }

                is Resource.Success -> {
                    mutableState.value = DataState(data = it.data)
                }
            }
        }.launchIn(coroutineScope)
    }
}