package org.hxl.favorite.menu.character

import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.common.base.BaseAdapter
import org.hxl.common.callback.CharacterItemCallBack
import org.hxl.discover.databinding.CharacterItemBinding
import org.hxl.discover.menu.charcater.CharacterListAdapter
import org.hxl.model.Character

class CharacterFavAdapter(
    private val favLogic: (isAdd: Boolean, id: Int) -> Unit
): BaseAdapter<Character, CharacterListAdapter.CharacterViewHolder>(CharacterItemCallBack) {
    override fun getViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): CharacterListAdapter.CharacterViewHolder {
        val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return CharacterListAdapter.CharacterViewHolder(favLogic, binding)
    }
}