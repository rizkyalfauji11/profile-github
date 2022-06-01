package id.alpha.code.main.usecase

import com.stockbit.repository.CryptoRepository

class GetCryptoUseCase constructor(
    private val repository: CryptoRepository
) {
    fun execute() = repository.getCrypto()
}