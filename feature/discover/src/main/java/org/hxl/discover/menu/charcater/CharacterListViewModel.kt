package org.hxl.discover.menu.charcater

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import org.hxl.discover.menu.ListDataPaging
import org.hxl.domain.usecase.character.CharacterUseCase
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(private val getCharacters: CharacterUseCase): ViewModel() {
    val characterListPager = Pager(
        PagingConfig(pageSize = 10)
    ){
        ListDataPaging {
            getCharacters.getCharacters(it)
        }
    }.flow.cachedIn(viewModelScope)
}