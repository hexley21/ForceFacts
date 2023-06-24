package org.hxl.common.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import java.util.function.Consumer

abstract class BaseViewHolder<VB: ViewDataBinding, T>(val binding: VB):
    RecyclerView.ViewHolder(binding.root), Consumer<T>