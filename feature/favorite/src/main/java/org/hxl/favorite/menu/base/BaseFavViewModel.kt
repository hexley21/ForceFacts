package org.hxl.favorite.menu.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

abstract class BaseFavViewModel<T: Any>(getData: () -> Flow<List<T>>): ViewModel() {
    val listFlow: Flow<List<T>> = getData()
}