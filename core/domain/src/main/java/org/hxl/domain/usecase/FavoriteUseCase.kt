package org.hxl.domain.usecase

import kotlinx.coroutines.flow.Flow

interface FavoriteUseCase<T: Any> {
    suspend fun favorite(id: Int)
    suspend fun unFavorite(id: Int)
    fun getFavorites(): Flow<List<T>>
}