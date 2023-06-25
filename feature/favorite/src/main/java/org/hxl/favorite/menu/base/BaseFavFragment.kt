package org.hxl.favorite.menu.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.hxl.common.base.BaseAdapter
import org.hxl.common.base.BaseFragmentVM
import org.hxl.discover.databinding.StarwarsListBinding
import java.net.UnknownHostException

abstract class BaseFavFragment<T: Any, VM: BaseFavViewModel<T>>: BaseFragmentVM<StarwarsListBinding, VM>() {
    protected lateinit var listAdapter: BaseAdapter<T, *>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvStarwarsList.adapter = listAdapter

        lifecycleScope.launch {
            listAdapter.registerAdapterDataObserver(
                object: RecyclerView.AdapterDataObserver() {

                }
            )
            vm.listFlow.collectLatest {
                listAdapter.submitList(it) {
                    hideError()
                    hideLoading()
                }
            }
        }

        binding.imgError.setOnClickListener { refresh() }
        binding.tvError.setOnClickListener { refresh() }

        binding.srlStarwars.setOnRefreshListener(::refresh)

    }

    private fun refresh() {
        hideLoading()
    }

    private fun hideError() {
        hideLoading()
        binding.imgError.visibility = View.GONE
        binding.tvError.visibility = View.GONE
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
        binding.srlStarwars.isRefreshing = false
    }
}