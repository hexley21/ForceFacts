package org.hxl.favorite.menu

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.hxl.common.R
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

    companion object {
        @JvmStatic
        fun attachTabMediator(tabLayout: TabLayout, pager: ViewPager2) {
            val context: Context = pager.context
            TabLayoutMediator(
                tabLayout,
                pager,
                true,
                true,
            ) { tab, position ->
                if (position == 0) tab.setText(context.getString(R.string.characters))
                else tab.setText(context.getString(R.string.star_ships))
            }.attach()
        }
    }
}