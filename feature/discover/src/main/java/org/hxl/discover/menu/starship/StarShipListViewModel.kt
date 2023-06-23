package org.hxl.discover.menu.starship

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import org.hxl.discover.menu.ListDataPaging
import org.hxl.domain.usecase.character.CharacterUseCase
import org.hxl.domain.usecase.starship.StarShipUseCase
import javax.inject.Inject

@HiltViewModel
class StarShipListViewModel @Inject constructor(private val getStarShip: StarShipUseCase): ViewModel() {
    val characterListPager = Pager(
        PagingConfig(pageSize = 10)
    ){
        ListDataPaging {
            getStarShip.getStarShips(it)
        }
    }.flow.cachedIn(viewModelScope)
}