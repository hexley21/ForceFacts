package org.hxl.common.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseFragmentVM<VB: ViewDataBinding, VM: ViewModel>: BaseFragment<VB>() {
    protected abstract val vm: VM
}