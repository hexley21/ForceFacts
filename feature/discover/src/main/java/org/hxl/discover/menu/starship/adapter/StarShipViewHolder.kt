package org.hxl.discover.menu.starship.adapter

import org.hxl.common.base.BaseViewHolder
import org.hxl.discover.databinding.StarshipItemBinding
import org.hxl.model.StarShip

class StarShipViewHolder(
    private val favLogic: (isAdd: Boolean, id: Int) -> Unit,
    binding: StarshipItemBinding
): BaseViewHolder<StarshipItemBinding, StarShip>(binding) {
    override fun accept(t: StarShip) {
        binding.starship = t
        binding.cbFavorite.setOnCheckedChangeListener { _, isChecked ->
            favLogic(!isChecked, t.id)
        }
    }

}