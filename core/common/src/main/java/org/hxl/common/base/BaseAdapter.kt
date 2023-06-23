package org.hxl.common.base

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.function.Consumer

abstract class BaseAdapter<T, VH>(comparator: DiffUtil.ItemCallback<T>): ListAdapter<T, VH>(comparator) where VH : RecyclerView.ViewHolder, VH: Consumer<T> {
    protected abstract fun getViewHolder(parent: ViewGroup?, viewType: Int): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return getViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.accept(getItem(position))
    }
}