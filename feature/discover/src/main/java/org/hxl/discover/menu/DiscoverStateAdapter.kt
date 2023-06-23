package org.hxl.discover.menu

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.hxl.discover.menu.charcater.CharacterListFragmentSearch
import org.hxl.discover.menu.starship.StarShipListFragmentSearch

class DiscoverStateAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position % 2) {
            1 -> StarShipListFragmentSearch()
            else -> CharacterListFragmentSearch()
        }
    }
}