package com.azmiradi.channel_app.data.di

import com.azmiradi.channel_app.data.network.home.HomeApi
import com.azmiradi.channel_app.data.network.home.HomeApiImpl
import com.azmiradi.channel_app.data.repository.HomeRepositoryImpl
import com.azmiradi.channel_app.domain.repository.HomeRepository
import com.azmiradi.channel_app.domain.use_case.GetChannelPlayListsUseCase
import com.azmiradi.channel_app.domain.use_case.GetPlayListVideosUseCase
import com.azmiradi.channel_app.presentation.screens.details.PlayListVideosScreenModel
import com.azmiradi.channel_app.presentation.screens.home.ChannelPlayListsScreenModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() = startKoin {
    modules(commonModule)
}

val commonModule = module {
    factory { GetChannelPlayListsUseCase(get()) }
    factory { GetPlayListVideosUseCase(get()) }
    factory { ChannelPlayListsScreenModel(get()) }
    factory { PlayListVideosScreenModel(get()) }
    factory<HomeApi> { HomeApiImpl() }
    factory<HomeRepository> { HomeRepositoryImpl(get()) }
}