package id.alpha.code.main.di

import id.alpha.code.main.fragment.HomeViewModel
import id.alpha.code.main.usecase.GetCryptoUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureHomeModule = module {
    factory { GetCryptoUseCase(get()) }
    viewModel { HomeViewModel(get()) }
}