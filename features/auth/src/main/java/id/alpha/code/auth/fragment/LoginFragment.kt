package id.alpha.code.auth.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import id.alpha.code.auth.databinding.FragmentLoginBinding
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private val viewModel: LoginViewModel by viewModel()

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun setBinding(layoutInflater: LayoutInflater): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpOnClickListener()
    }

    private fun setUpOnClickListener() {
        binding.tvLogin.setOnClickListener {
            viewModel.navigateToHome()
        }
    }
}