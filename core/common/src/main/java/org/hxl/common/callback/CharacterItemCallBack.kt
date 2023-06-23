package org.hxl.common.callback

import androidx.recyclerview.widget.DiffUtil
import org.hxl.model.Character

object CharacterItemCallBack: DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}