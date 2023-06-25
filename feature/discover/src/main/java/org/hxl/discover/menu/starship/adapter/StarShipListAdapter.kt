package org.hxl.discover.menu.starship.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.common.base.BasePagingAdapter
import org.hxl.common.callback.StarShipItemCallback
import org.hxl.discover.databinding.StarshipItemBinding
import org.hxl.model.StarShip

class StarShipListAdapter(
    private val favLogic: (isAdd: Boolean, id: Int) -> Unit
): BasePagingAdapter<StarShip, StarShipViewHolder>(StarShipItemCallback) {

    override fun getViewHolder(parent: ViewGroup?, viewType: Int): StarShipViewHolder {
        val binding: StarshipItemBinding = StarshipItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return StarShipViewHolder(favLogic, binding)
    }

}
