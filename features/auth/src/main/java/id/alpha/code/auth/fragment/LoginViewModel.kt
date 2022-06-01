package id.alpha.code.auth.fragment

import com.stockbit.common.base.BaseViewModel

class LoginViewModel : BaseViewModel() {
    fun navigateToHome() = navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
}