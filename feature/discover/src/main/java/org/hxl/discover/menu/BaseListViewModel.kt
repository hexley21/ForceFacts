package org.hxl.discover.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

abstract class BaseListViewModel<T: Any>(private val getData: suspend (query: String, page: Int) -> List<T>): ViewModel() {
    private var searchQuery: String = ""
    private var pager: Pager<Int, T>? = null

    private val searchQueryFlow = MutableStateFlow("")

    var listFlow: Flow<PagingData<T>>? = null
        get() {
            if (field == null) {
                updateListFlow()
            }
            return field
        }

    private fun createOrGetPager(): Pager<Int, T> {
        if (pager == null) {
            pager = Pager(
                PagingConfig(
                    pageSize = 10,
                    enablePlaceholders = false
                )
            ) {
                ListDataPaging {
                    getData(searchQuery, it)
                }
            }
        }
        return pager!!
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun updateListFlow() {
        listFlow = searchQueryFlow.flatMapLatest {
            searchQuery = it
            createOrGetPager().flow.cachedIn(viewModelScope)
        }
    }

    fun submitSearch(query: String) {
        searchQueryFlow.value = query
        updateListFlow()
    }
}