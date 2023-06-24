package org.hxl.favorite.menu.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import org.hxl.discover.menu.ListDataPaging

abstract class BaseFavViewModel<T: Any>(private val getData: suspend (page: Int) -> List<T>): ViewModel() {
    val listFlow: Flow<PagingData<T>> =
        Pager(
            PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            )
        ) {
            ListDataPaging {
                getData(it)
            }
        }.flow.cachedIn(viewModelScope)
}