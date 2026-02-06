package com.ameth.voltio.features.products.domain.usecase

import com.ameth.voltio.features.products.domain.entities.Product
import com.ameth.voltio.features.products.domain.repositories.IProductRepository

class GetProductsUseCase(
    private val repository: IProductRepository
) {
    suspend operator fun invoke(): Result<List<Product>> {
        return try {
            val products = repository.getProducts()
            Result.success(products)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
