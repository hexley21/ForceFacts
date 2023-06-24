package org.hxl.favorite.menu.starship

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.hxl.domain.usecase.starship.FavoriteStarShipUseCase
import org.hxl.favorite.menu.base.BaseFavViewModel
import org.hxl.model.StarShip
import javax.inject.Inject

@HiltViewModel
class StarShipFavViewModel @Inject constructor(private val getFavorite: FavoriteStarShipUseCase):
    BaseFavViewModel<StarShip>(getFavorite::getFavoriteStarShips) {
    companion object {
        private const val TAG = "CharacterDiscoverVM"
    }

    fun favoriteCharacter(isRemove: Boolean, id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (isRemove) {
                    getFavorite.favoriteStarShip(id)
                    Log.d(TAG, "favoriteCharacter: add")
                } else {
                    getFavorite.favoriteStarShip(id)
                    Log.d(TAG, "favoriteCharacter: remove")
                }
            }
        }
    }
}