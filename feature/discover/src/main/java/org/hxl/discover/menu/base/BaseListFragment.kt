package org.hxl.discover.menu.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.hxl.common.base.BaseFragmentVM
import org.hxl.common.base.BasePagingAdapter
import org.hxl.discover.databinding.StarwarsListBinding
import java.net.UnknownHostException

abstract class BaseListFragment<T: Any, VM: BaseListViewModel<T>>: BaseFragmentVM<StarwarsListBinding, VM>() {
    protected lateinit var listAdapter: BasePagingAdapter<T, *>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvStarwarsList.adapter = listAdapter

        lifecycleScope.launch {
            listAdapter.addLoadStateListener{
                if (it.refresh is LoadState.Loading) {
                    if (binding.pbMiddle.visibility == View.GONE) {
                        binding.pbTop.visibility = View.VISIBLE
                    }
//                    EspressoIdlingResource.increment();
                }
                else if (it.refresh is LoadState.NotLoading) {

                    hideError()
                    hideLoading()
//                    EspressoIdlingResource.decrement();
                } else if (it.refresh is LoadState.Error) {
                    showError((it.refresh as LoadState.Error).error)
                    hideLoading()
                }
            }
            vm.listFlow?.collectLatest {
                listAdapter.submitData(it)
            }
        }

        binding.imgError.setOnClickListener { refresh() }
        binding.tvError.setOnClickListener { refresh() }

        binding.srlStarwars.setOnRefreshListener(::refresh)

    }

    private fun refresh() {
        listAdapter.refresh()
    }

    private fun hideError() {
        binding.imgError.visibility = View.GONE
        binding.tvError.visibility = View.GONE
        binding.srlStarwars.isRefreshing = false
    }

    private fun showError(e: Throwable) {
        if (listAdapter.itemCount == 0) {
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
        binding.pbTop.visibility = View.GONE
        binding.pbMiddle.visibility = View.GONE
    }
}