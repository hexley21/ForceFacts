package org.hxl.discover.menu.charcater.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.common.base.BasePagingAdapter
import org.hxl.common.callback.CharacterItemCallBack
import org.hxl.discover.databinding.CharacterItemBinding
import org.hxl.model.Character

class CharacterListAdapter(
    private val favLogic: (isAdd: Boolean, id: Int) -> Unit
): BasePagingAdapter<Character, CharacterViewHolder>(CharacterItemCallBack) {

    override fun getViewHolder(parent: ViewGroup?, viewType: Int): CharacterViewHolder {
        val binding: CharacterItemBinding = CharacterItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return CharacterViewHolder(favLogic, binding)
    }

}
