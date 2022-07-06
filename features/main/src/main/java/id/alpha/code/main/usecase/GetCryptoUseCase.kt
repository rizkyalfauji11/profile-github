package id.alpha.code.main.usecase

import com.alpha.repository.CryptoRepository

class GetCryptoUseCase constructor(
    private val repository: CryptoRepository
) {
    fun execute() = repository.getCrypto()
}