package org.hxl.discover.menu.charcater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.hxl.common.base.BasePagingAdapter
import org.hxl.discover.databinding.StarwarsListBinding
import org.hxl.discover.menu.BaseListFragment
import org.hxl.model.Character

@AndroidEntryPoint
class CharacterListFragmentSearch : BaseListFragment<Character, CharacterListViewModel>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): StarwarsListBinding {
        return StarwarsListBinding.inflate(inflater, container, false)
    }

    override val vm: CharacterListViewModel  by viewModels(
        ownerProducer = { requireParentFragment() }
    )
    override val listAdapter: BasePagingAdapter<Character, *> = CharacterListAdapter()
}