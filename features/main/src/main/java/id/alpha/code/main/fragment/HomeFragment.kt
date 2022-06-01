package id.alpha.code.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import id.alpha.code.main.adapter.CryptoListAdapter
import id.alpha.code.main.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collect
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val adapter by lazy {
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
    }

    private fun configureViewModel() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            homeViewModel.getCrypto().collect { value ->
                adapter.submitData(value)
            }
        }
    }

    private fun configureRecyclerView() {
        adapter.addLoadStateListener {
            if (it.refresh is LoadState.Loading)
                binding.pbLoading.visibility = View.VISIBLE
            else
                binding.pbLoading.visibility = View.GONE
        }
        binding.rvCrypto.adapter = adapter
    }
}