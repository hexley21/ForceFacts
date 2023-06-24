package org.hxl.navigator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationBarView
import dagger.hilt.android.AndroidEntryPoint
import org.hxl.common.base.BaseFragment
import org.hxl.navigator.databinding.FragmentNavigatorBinding

@AndroidEntryPoint
class NavigatorFragment: BaseFragment<FragmentNavigatorBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navigatorItemListener = NavigationBarView.OnItemSelectedListener {
            onMenuItemSelect(it.itemId)
        }
        binding.bottomNavigation?.setOnItemSelectedListener(navigatorItemListener)
        binding.railNavigator?.setOnItemSelectedListener(navigatorItemListener)
        binding.viewNavigator?.setNavigationItemSelectedListener { onMenuItemSelect(it.itemId)}
    }

    private fun NavigatorFragment.findMainNavController() = NavHostFragment.findNavController(this)
    private fun NavigatorFragment.findNavController() = Navigation.findNavController(binding.navigatorContainer)

    private fun onMenuItemSelect(id: Int): Boolean {
        when (id) {
            R.id.menu_favorites -> {
                findNavController().navigate(org.hxl.favorite.R.id.nav_favorite)
            }
            else -> {
                findNavController().navigate(org.hxl.discover.R.id.nav_discover)
            }
        }
        return true
    }
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNavigatorBinding {
        return FragmentNavigatorBinding.inflate(layoutInflater, container, false)
    }
}