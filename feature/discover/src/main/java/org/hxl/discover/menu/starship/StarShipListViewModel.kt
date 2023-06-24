package org.hxl.discover.menu.starship

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.hxl.discover.menu.base.BaseListViewModel
import org.hxl.domain.usecase.starship.FavoriteStarShipUseCase
import org.hxl.domain.usecase.starship.StarShipUseCase
import org.hxl.model.StarShip
import javax.inject.Inject

@HiltViewModel
class StarShipListViewModel @Inject constructor(
    getStarShip: StarShipUseCase,
    private val getFavorite: FavoriteStarShipUseCase
): BaseListViewModel<StarShip>(getStarShip::searchStarShips) {

    fun favorite(isAdd: Boolean, id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (isAdd) {
                    getFavorite.favoriteStarShip(id)
                } else {
                    getFavorite.favoriteStarShip(id)
                }
            }
        }
    }
}