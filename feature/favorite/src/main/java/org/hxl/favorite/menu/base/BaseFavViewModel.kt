package org.hxl.favorite.menu.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.hxl.domain.usecase.FavoriteUseCase

abstract class BaseFavViewModel<T: Any>(
    private val favoriteUseCase: FavoriteUseCase<T>
): ViewModel() {
    val listFlow: Flow<List<T>> = favoriteUseCase.getFavorites().flowOn(Dispatchers.IO)

    fun favorite(isAdd: Boolean, id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (isAdd) {
                    favoriteUseCase.favorite(id)
                } else {
                    favoriteUseCase.unFavorite(id)
                }
            }
        }
    }

}