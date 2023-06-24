package org.hxl.favorite.menu.starship

import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.common.base.BaseAdapter
import org.hxl.common.callback.StarShipItemCallback
import org.hxl.discover.databinding.StarshipItemBinding
import org.hxl.discover.menu.starship.StarShipListAdapter
import org.hxl.model.StarShip

class StarShipFavAdapter(
    private val favLogic: (isAdd: Boolean, id: Int) -> Unit
): BaseAdapter<StarShip, StarShipListAdapter.StarShipViewHolder>(StarShipItemCallback) {
    override fun getViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): StarShipListAdapter.StarShipViewHolder {
        val binding = StarshipItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return StarShipListAdapter.StarShipViewHolder(favLogic, binding)
    }
}