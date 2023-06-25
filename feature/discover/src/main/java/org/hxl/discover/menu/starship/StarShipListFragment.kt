package org.hxl.discover.menu.starship

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.hxl.discover.databinding.StarwarsListBinding
import org.hxl.discover.menu.base.BaseListFragment
import org.hxl.discover.menu.starship.adapter.StarShipListAdapter
import org.hxl.model.StarShip

@AndroidEntryPoint
class StarShipListFragment : BaseListFragment<StarShip, StarShipListViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = StarShipListAdapter(vm::favorite)
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