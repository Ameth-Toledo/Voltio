package com.ameth.voltio.features.products.domain.usecase

import com.ameth.voltio.features.products.domain.repositories.IProductRepository

class DeleteProductUseCase(
    private val repository: IProductRepository
) {
    suspend operator fun invoke(id: Int): Result<Unit> {
        return try {
            repository.deleteProduct(id)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
