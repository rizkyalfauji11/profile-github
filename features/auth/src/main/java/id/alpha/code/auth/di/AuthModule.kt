package id.alpha.code.auth.di

import id.alpha.code.auth.fragment.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureAuthModule = module {
    viewModel { LoginViewModel() }
}