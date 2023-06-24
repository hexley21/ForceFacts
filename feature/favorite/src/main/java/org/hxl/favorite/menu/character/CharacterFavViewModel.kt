package org.hxl.favorite.menu.character

import dagger.hilt.android.lifecycle.HiltViewModel
import org.hxl.domain.usecase.character.FavoriteCharacterUseCase
import org.hxl.favorite.menu.base.BaseFavViewModel
import org.hxl.model.Character
import javax.inject.Inject

@HiltViewModel
class CharacterFavViewModel @Inject constructor(private val getFavorites: FavoriteCharacterUseCase):
    BaseFavViewModel<Character>(getFavorites::getFavoriteCharacters)