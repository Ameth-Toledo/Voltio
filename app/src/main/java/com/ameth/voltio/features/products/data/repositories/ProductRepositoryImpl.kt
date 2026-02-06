package com.ameth.voltio.features.products.data.repositories

import com.ameth.voltio.features.products.data.datasource.remote.ProductApiService
import com.ameth.voltio.features.products.data.datasource.remote.mapper.toDomain
import com.ameth.voltio.features.products.data.datasource.remote.model.CreateProductRequest
import com.ameth.voltio.features.products.domain.entities.Product
import com.ameth.voltio.features.products.domain.repositories.IProductRepository

class ProductRepositoryImpl(
    private val api: ProductApiService
) : IProductRepository {

    override suspend fun getProducts(): List<Product> {
        val response = api.getProducts()
        return response.map { it.toDomain() }
    }

    override suspend fun getProductById(id: Int): Product {
        val response = api.getProductById(id)
        return response.toDomain()
    }

    override suspend fun createProduct(request: CreateProductRequest): Product {
        val response = api.createProduct(request)
        return response.toDomain()
    }

    override suspend fun updateProduct(id: Int, request: CreateProductRequest): Product {
        val response = api.updateProduct(id, request)
        return response.toDomain()
    }

    override suspend fun deleteProduct(id: Int) {
        api.deleteProduct(id)
    }
}
