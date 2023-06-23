package org.hxl.discover

import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import org.hxl.common.base.BaseFragment
import org.hxl.discover.databinding.FragmentDiscoverBinding

@AndroidEntryPoint
class DiscoverFragment: BaseFragment<FragmentDiscoverBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDiscoverBinding {
        return FragmentDiscoverBinding.inflate(inflater, container, false)
    }
}