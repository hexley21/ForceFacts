package org.hxl.discover.menu.starship

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.hxl.common.base.BaseFragmentVM
import org.hxl.common.base.BasePagingAdapter
import org.hxl.discover.databinding.StarwarsListBinding
import org.hxl.discover.menu.BaseListFragment
import org.hxl.discover.menu.charcater.CharacterListAdapter
import org.hxl.discover.menu.charcater.CharacterListViewModel
import org.hxl.model.Character
import org.hxl.model.StarShip
import java.net.UnknownHostException

@AndroidEntryPoint
class StarShipListFragment : BaseListFragment<StarShip, StarShipListViewModel>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): StarwarsListBinding {
        return StarwarsListBinding.inflate(inflater, container, false)
    }

    override val vm: StarShipListViewModel by viewModels()
    override val listAdapter: BasePagingAdapter<StarShip, *> = StarShipListAdapter()
}