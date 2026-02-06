package com.ameth.voltio.features.products.domain.usecase

import com.ameth.voltio.features.products.domain.entities.Product
import com.ameth.voltio.features.products.domain.repositories.IProductRepository

class GetProductByIdUseCase(
    private val repository: IProductRepository
) {
    suspend operator fun invoke(id: Int): Result<Product> {
        return try {
            val product = repository.getProductById(id)
            Result.success(product)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
