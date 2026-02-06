package com.ameth.voltio.features.products.domain.repositories

import com.ameth.voltio.features.products.data.datasource.remote.model.CreateProductRequest
import com.ameth.voltio.features.products.domain.entities.Product

interface IProductRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProductById(id: Int): Product
    suspend fun createProduct(request: CreateProductRequest): Product
    suspend fun updateProduct(id: Int, request: CreateProductRequest): Product
    suspend fun deleteProduct(id: Int)
}
