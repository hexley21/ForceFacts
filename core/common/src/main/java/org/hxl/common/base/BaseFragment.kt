package org.hxl.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB: ViewDataBinding>: Fragment() {
    protected lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater, container)
        beforeCreatingView(savedInstanceState)
        return binding.root
    }

    protected open fun beforeCreatingView(savedInstanceState: Bundle?) {}

    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

}