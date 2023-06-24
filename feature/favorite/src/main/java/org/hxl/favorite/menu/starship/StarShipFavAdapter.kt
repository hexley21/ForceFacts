package org.hxl.favorite.menu.starship

import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.common.base.BaseAdapter
import org.hxl.common.callback.StarShipItemCallback
import org.hxl.discover.databinding.StarshipItemBinding
import org.hxl.discover.menu.starship.adapter.StarShipViewHolder
import org.hxl.model.FilmInfo
import org.hxl.model.StarShip

class StarShipFavAdapter(
    private val favLogic: (isAdd: Boolean, id: Int) -> Unit
): BaseAdapter<StarShip, StarShipViewHolder>(StarShipItemCallback) {
    override fun getViewHolder(parent: ViewGroup?, viewType: Int): StarShipViewHolder {
        val binding = StarshipItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return StarShipViewHolder(favLogic, binding)
    }

    override fun onBindViewHolder(holder: StarShipViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
    }
}