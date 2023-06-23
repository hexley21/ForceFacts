package org.hxl.discover.menu.starship

import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.common.base.BasePagingAdapter
import org.hxl.common.base.BaseViewHolder
import org.hxl.common.callback.StarShipItemCallback
import org.hxl.discover.databinding.StarshipItemBinding
import org.hxl.model.StarShip

class StarShipListAdapter: BasePagingAdapter<StarShip, StarShipListAdapter.StarShipViewHolder>(
    StarShipItemCallback
) {
    inner class StarShipViewHolder(binding: StarshipItemBinding): BaseViewHolder<StarshipItemBinding, StarShip>(binding) {
        override fun accept(t: StarShip) {
            binding.starship = t
        }

    }

    override fun getViewHolder(parent: ViewGroup?, viewType: Int): StarShipViewHolder {
        val binding: StarshipItemBinding = StarshipItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return StarShipViewHolder(binding)
    }

}
