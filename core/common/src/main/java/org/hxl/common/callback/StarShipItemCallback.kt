package org.hxl.common.callback

import androidx.recyclerview.widget.DiffUtil
import org.hxl.model.StarShip

object StarShipItemCallback: DiffUtil.ItemCallback<StarShip>() {
    override fun areItemsTheSame(oldItem: StarShip, newItem: StarShip): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: StarShip, newItem: StarShip): Boolean {
        return oldItem == newItem
    }
}