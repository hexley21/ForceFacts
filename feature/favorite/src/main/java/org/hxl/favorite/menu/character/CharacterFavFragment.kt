package org.hxl.favorite.menu.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.hxl.discover.databinding.StarwarsListBinding
import org.hxl.favorite.menu.base.BaseFavFragment
import org.hxl.model.Character

@AndroidEntryPoint
class CharacterFavFragment : BaseFavFragment<Character, CharacterFavViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = CharacterFavAdapter(vm::favorite)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): StarwarsListBinding {
        return StarwarsListBinding.inflate(inflater, container, false)
    }

    override val vm: CharacterFavViewModel by viewModels()
}