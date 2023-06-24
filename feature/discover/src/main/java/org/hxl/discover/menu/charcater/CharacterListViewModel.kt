package org.hxl.discover.menu.charcater

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.hxl.discover.menu.base.BaseListViewModel
import org.hxl.domain.usecase.character.CharacterUseCase
import org.hxl.domain.usecase.character.FavoriteCharacterUseCase
import org.hxl.model.Character
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    getCharacters: CharacterUseCase,
    private val getFavorite: FavoriteCharacterUseCase
): BaseListViewModel<Character>(getCharacters::searchCharacters) {
    companion object {
        private const val TAG = "CharacterDiscoverVM"
    }

    fun favoriteCharacter(isRemove: Boolean, id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (isRemove) {
                    getFavorite.favoriteCharacter(id)
                } else {
                    getFavorite.unFavoriteCharacter(id)
                }
            }
        }
    }
}