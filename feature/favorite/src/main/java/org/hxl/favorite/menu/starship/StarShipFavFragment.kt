package org.hxl.favorite.menu.starship

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.hxl.discover.databinding.StarwarsListBinding
import org.hxl.discover.menu.starship.StarShipListAdapter
import org.hxl.favorite.menu.base.BaseFavFragment
import org.hxl.model.StarShip

@AndroidEntryPoint
class StarShipFavFragment : BaseFavFragment<StarShip, StarShipFavViewModel>() {

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

    override val vm: StarShipFavViewModel  by viewModels()
}