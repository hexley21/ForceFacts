package org.hxl.favorite.menu

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.hxl.favorite.menu.character.CharacterFavFragment
import org.hxl.favorite.menu.starship.StarShipFavFragment

class FavoriteStateAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position % 2) {
            1 -> StarShipFavFragment()
            else -> CharacterFavFragment()
        }
    }
}