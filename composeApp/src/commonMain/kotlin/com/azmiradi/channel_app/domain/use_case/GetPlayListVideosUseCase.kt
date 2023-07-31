package com.azmiradi.channel_app.domain.use_case

import com.azmiradi.channel_app.domain.Resource
import com.azmiradi.channel_app.domain.repository.HomeRepository
import com.azmiradi.channel_app.presentation.utils.coroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetPlayListVideosUseCase(private val homeRepository: HomeRepository) {
    operator fun invoke(playListID: String) = flow {
        emit(Resource.Loading())
        try {
            val response = homeRepository.getPlayListVideos(playListID = playListID)
            emit(Resource.Success(response))
        } catch (throwable: Throwable) {
            emit(Resource.Error(throwable.message ?: ""))
        }
    }.flowOn(coroutineDispatcher())
}