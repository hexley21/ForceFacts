package org.hxl.discover.menu.charcater

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.hxl.discover.databinding.StarwarsListBinding
import org.hxl.discover.menu.base.BaseListFragment
import org.hxl.model.Character

@AndroidEntryPoint
class CharacterListFragment : BaseListFragment<Character, CharacterListViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = CharacterListAdapter(vm::favoriteCharacter)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): StarwarsListBinding {
        return StarwarsListBinding.inflate(inflater, container, false)
    }

    override val vm: CharacterListViewModel  by viewModels(
        ownerProducer = { requireParentFragment() }
    )
}