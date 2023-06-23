package org.hxl.discover.menu.starship

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.hxl.common.base.BaseFragmentVM
import org.hxl.discover.databinding.StarwarsListBinding
import java.net.UnknownHostException

@AndroidEntryPoint
class StarShipListFragment : BaseFragmentVM<StarwarsListBinding, StarShipListViewModel>() {
    override val vm: StarShipListViewModel by viewModels()
    private val starShipListAdapter = StarShipListAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvStarwarsList.adapter = starShipListAdapter

        lifecycleScope.launch {
            starShipListAdapter.addLoadStateListener{
//                if (it.refresh is LoadState.Loading) {
//                    EspressoIdlingResource.increment();
//                }
                if (it.refresh is LoadState.NotLoading) {

                    hideError()
                    hideLoading()
//                    EspressoIdlingResource.decrement();
                } else if (it.refresh is LoadState.Error) {
                    showError((it.refresh as LoadState.Error).error)
                    hideLoading()
                }
            }
            vm.characterListPager.collectLatest {
                starShipListAdapter.submitData(it)
            }
        }

        binding.imgError.setOnClickListener { refresh() }
        binding.tvError.setOnClickListener { refresh() }

        binding.srlStarwars.setOnRefreshListener(::refresh)

    }

    private fun refresh() {
        starShipListAdapter.refresh()
    }

    private fun hideError() {
        binding.imgError.visibility = View.GONE
        binding.tvError.visibility = View.GONE
        binding.srlStarwars.isRefreshing = false
    }

    private fun showError(e: Throwable) {
        if (starShipListAdapter.itemCount == 0) {
            if (e is UnknownHostException) {
                binding.error = Exception("No internet connection…")
            } else {
                binding.error = e
            }
            binding.imgError.visibility = View.VISIBLE
            binding.tvError.visibility = View.VISIBLE
        }
        else {
            if (e is UnknownHostException) {
                showSnackBar("No internet connection…")
            } else {
                showSnackBar(e.message ?: "Something went wrong")
            }
        }
        binding.srlStarwars.isRefreshing = false
    }

    private fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): StarwarsListBinding {
        return StarwarsListBinding.inflate(inflater, container, false)
    }
}