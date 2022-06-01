package id.alpha.code.main.fragment

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.stockbit.common.base.BaseViewModel
import id.alpha.code.main.usecase.GetCryptoUseCase

class HomeViewModel(
    private val getCryptoUseCase: GetCryptoUseCase
) : BaseViewModel() {

    fun getCrypto() = getCryptoUseCase.execute()
        .cachedIn(viewModelScope)
}