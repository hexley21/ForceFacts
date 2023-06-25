package org.hxl.discover.menu

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.hxl.common.R
import org.hxl.discover.menu.charcater.CharacterListFragment
import org.hxl.discover.menu.starship.StarShipListFragment

class DiscoverStateAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position % 2) {
            1 -> StarShipListFragment()
            else -> CharacterListFragment()
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