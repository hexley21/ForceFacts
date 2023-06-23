package org.hxl.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import org.hxl.common.R
import org.hxl.common.base.BaseFragment
import org.hxl.discover.databinding.FragmentDiscoverBinding
import org.hxl.discover.menu.DiscoverStateAdapter

@AndroidEntryPoint
class DiscoverFragment: BaseFragment<FragmentDiscoverBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attachTabMediator(binding.listTabs, binding.listPager)
        attachTabMediator(binding.searchListTabs, binding.searchListPager)
    }

    private fun attachTabMediator(tabLayout: TabLayout, pager: ViewPager2) {
        pager.adapter = DiscoverStateAdapter(this)
        pager.isUserInputEnabled = false

        TabLayoutMediator(
            tabLayout,
            pager,
            true,
            true,
        ) { tab, position ->
            if (position == 0) tab.setText(requireContext().getString(R.string.characters))
            else tab.setText(requireContext().getString(R.string.star_ships))
        }.attach()
    }
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDiscoverBinding {
        return FragmentDiscoverBinding.inflate(inflater, container, false)
    }
}