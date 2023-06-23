package org.hxl.common.base

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.function.Consumer

abstract class BasePagingAdapter<T: Any, VH>(comparator: DiffUtil.ItemCallback<T>):
    PagingDataAdapter<T, VH>(comparator)  where VH : RecyclerView.ViewHolder, VH: Consumer<T> {
    protected abstract fun getViewHolder(parent: ViewGroup?, viewType: Int): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return getViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position)?.let { holder.accept(it) }
    }
}