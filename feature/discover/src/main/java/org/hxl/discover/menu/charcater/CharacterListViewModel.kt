package org.hxl.discover.menu.charcater

import dagger.hilt.android.lifecycle.HiltViewModel
import org.hxl.discover.menu.base.BaseListViewModel
import org.hxl.domain.usecase.character.CharacterUseCase
import org.hxl.model.Character
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(getCharacters: CharacterUseCase): BaseListViewModel<Character>(getCharacters::searchCharacters)