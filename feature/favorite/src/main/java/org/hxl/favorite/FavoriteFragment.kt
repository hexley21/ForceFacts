package org.hxl.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import org.hxl.common.base.BaseFragment
import org.hxl.discover.menu.DiscoverStateAdapter.Companion.attachTabMediator
import org.hxl.favorite.databinding.FragmentFavoriteBinding
import org.hxl.favorite.menu.FavoriteStateAdapter

@AndroidEntryPoint
class FavoriteFragment: BaseFragment<FragmentFavoriteBinding>() {
    private lateinit var pagerAdapter: FavoriteStateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pagerAdapter = FavoriteStateAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listPager.adapter = pagerAdapter
        binding.listPager.isUserInputEnabled = false

        attachTabMediator(binding.listTabs, binding.listPager)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(inflater, container, false)
    }
}