package id.alpha.code.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import id.alpha.code.main.adapter.CryptoListAdapter
import id.alpha.code.main.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collect
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val listAdapter by lazy {
        CryptoListAdapter()
    }

    override fun getViewModel(): BaseViewModel {
        return homeViewModel
    }

    override fun setBinding(layoutInflater: LayoutInflater): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
        configureViewModel()
        configureSwipeLayout()
    }

    private fun configureSwipeLayout() {
        binding.swipeLayout.setOnRefreshListener {
            binding.swipeLayout.isRefreshing = false
            listAdapter.refresh()
        }
    }

    private fun configureViewModel() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            homeViewModel.getCrypto().collect { value ->
                listAdapter.submitData(value)
            }
        }
    }

    private fun configureRecyclerView() {
        listAdapter.addLoadStateListener {
            if (it.refresh is LoadState.Loading)
                binding.pbLoading.visibility = View.VISIBLE
            else
                binding.pbLoading.visibility = View.GONE
        }
        with(binding.rvCrypto) {
            adapter = listAdapter
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }
}