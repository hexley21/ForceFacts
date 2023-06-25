package org.hxl.discover.menu.charcater.adapter

import org.hxl.common.base.BaseViewHolder
import org.hxl.discover.databinding.CharacterItemBinding
import org.hxl.model.Character

class CharacterViewHolder(
    private val favLogic: (isAdd: Boolean, id: Int) -> Unit,
    binding: CharacterItemBinding
): BaseViewHolder<CharacterItemBinding, Character>(binding) {
    override fun accept(t: Character) {
        binding.character = t
        binding.cbFavorite.setOnCheckedChangeListener { _, isChecked ->
            favLogic(isChecked, t.id)
        }
    }

}