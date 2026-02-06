package com.ameth.voltio.features.products.domain.usecase

import com.ameth.voltio.features.products.data.datasource.remote.model.CreateProductRequest
import com.ameth.voltio.features.products.domain.entities.Product
import com.ameth.voltio.features.products.domain.repositories.IProductRepository

class UpdateProductUseCase(
    private val repository: IProductRepository
) {
    suspend operator fun invoke(id: Int, request: CreateProductRequest): Result<Product> {
        return try {
            val product = repository.updateProduct(id, request)
            Result.success(product)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
