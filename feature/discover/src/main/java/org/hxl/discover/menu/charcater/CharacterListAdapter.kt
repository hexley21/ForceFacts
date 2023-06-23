package org.hxl.discover.menu.charcater

import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.common.base.BasePagingAdapter
import org.hxl.common.base.BaseViewHolder
import org.hxl.common.callback.CharacterItemCallBack
import org.hxl.discover.databinding.CharacterItemBinding
import org.hxl.model.Character

class CharacterListAdapter: BasePagingAdapter<Character, CharacterListAdapter.CharacterViewHolder>(
    CharacterItemCallBack
) {
    inner class CharacterViewHolder(binding: CharacterItemBinding): BaseViewHolder<CharacterItemBinding, Character>(binding) {
        override fun accept(t: Character) {
            binding.character = t
        }

    }

    override fun getViewHolder(parent: ViewGroup?, viewType: Int): CharacterViewHolder {
        val binding: CharacterItemBinding = CharacterItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return CharacterViewHolder(binding)
    }

}
