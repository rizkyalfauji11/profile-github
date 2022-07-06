package id.alpha.code.auth.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alpha.common.base.BaseFragment
import com.alpha.common.base.BaseViewModel
import id.alpha.code.auth.R
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
        setUpToolbar()
    }

    private fun setUpToolbar() {
        binding.toolbar.title = ""
        binding.toolbar.setNavigationIcon(R.drawable.ic_back)
        (activity as AppCompatActivity?)?.setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_login, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun setUpOnClickListener() {
        binding.layoutBody.tvLogin.setOnClickListener {
            viewModel.navigateToHome()
        }
    }
}