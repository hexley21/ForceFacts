package org.hxl.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.hxl.common.base.BaseFragment
import org.hxl.discover.databinding.FragmentDiscoverBinding
import org.hxl.discover.menu.DiscoverStateAdapter
import org.hxl.discover.menu.DiscoverStateAdapter.Companion.attachTabMediator
import org.hxl.discover.menu.charcater.CharacterListViewModel
import org.hxl.discover.menu.starship.StarShipListViewModel


@AndroidEntryPoint
class DiscoverFragment: BaseFragment<FragmentDiscoverBinding>() {
    private val searchCharacterVm: CharacterListViewModel by viewModels()
    private val searchStarShipVm: StarShipListViewModel by viewModels()

    private lateinit var pagerAdapter: DiscoverStateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pagerAdapter = DiscoverStateAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listPager.adapter = pagerAdapter
        binding.listPager.isUserInputEnabled = false

        attachTabMediator(binding.listTabs, binding.listPager)

        binding.searchDiscover.setOnQueryTextListener(
            object : OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    val length = newText?.length ?: 0
                    if (length > 1) {
                        submitSearch(newText.toString())
                    } else if (length == 0) {
                        submitSearch("")
                    }
                    return false
                }
            }
        )
    }

    private fun submitSearch(query: String) {
        searchCharacterVm.submitSearch(query)
        searchStarShipVm.submitSearch(query)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDiscoverBinding {
        return FragmentDiscoverBinding.inflate(inflater, container, false)
    }
}