package org.hxl.favorite.menu.character

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.hxl.domain.usecase.character.FavoriteCharacterUseCase
import org.hxl.favorite.menu.base.BaseFavViewModel
import org.hxl.model.Character
import javax.inject.Inject

@HiltViewModel
class CharacterFavViewModel @Inject constructor(
    private val getFavorite: FavoriteCharacterUseCase
): BaseFavViewModel<Character>(getFavorite::getFavoriteCharacters) {
    companion object {
        private const val TAG = "CharacterDiscoverVM"
    }

    fun favoriteCharacter(isRemove: Boolean, id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (isRemove) {
                    getFavorite.favoriteCharacter(id)
                    Log.d(TAG, "favoriteCharacter: add")
                } else {
                    getFavorite.unFavoriteCharacter(id)
                    Log.d(TAG, "favoriteCharacter: remove")
                }
            }
        }
    }
}