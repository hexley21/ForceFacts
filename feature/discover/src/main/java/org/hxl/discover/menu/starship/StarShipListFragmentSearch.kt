package org.hxl.discover.menu.starship

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.hxl.common.base.BasePagingAdapter
import org.hxl.discover.databinding.StarwarsListBinding
import org.hxl.discover.menu.BaseListFragment
import org.hxl.model.StarShip

@AndroidEntryPoint
class StarShipListFragmentSearch : BaseListFragment<StarShip, StarShipListViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = StarShipListAdapter()
    }
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): StarwarsListBinding {
        return StarwarsListBinding.inflate(inflater, container, false)
    }

    override val vm: StarShipListViewModel  by viewModels(
        ownerProducer = { requireParentFragment() }
    )
}