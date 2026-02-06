package com.ameth.voltio.features.products.di

import com.ameth.voltio.core.di.AppContainer
import com.ameth.voltio.features.products.data.datasource.remote.ProductApiService
import com.ameth.voltio.features.products.data.repositories.ProductRepositoryImpl
import com.ameth.voltio.features.products.domain.usecase.*
import com.ameth.voltio.features.products.presentation.viewmodel.ProductViewModelFactory

class ProductModule(private val appContainer: AppContainer) {

    private val productApiService: ProductApiService by lazy {
        appContainer.retrofit.create(ProductApiService::class.java)
    }

    private val productRepository by lazy {
        ProductRepositoryImpl(productApiService)
    }

    private val getProductsUseCase by lazy {
        GetProductsUseCase(productRepository)
    }
    private val deleteProductUseCase by lazy {
        DeleteProductUseCase(productRepository)
    }
    private val getProductByIdUseCase by lazy {
        GetProductByIdUseCase(productRepository)
    }
    private val createProductUseCase by lazy {
        CreateProductUseCase(productRepository)
    }
    private val updateProductUseCase by lazy {
        UpdateProductUseCase(productRepository)
    }

    fun provideProductViewModelFactory(): ProductViewModelFactory {
        return ProductViewModelFactory(
            getProductsUseCase,
            getProductByIdUseCase,
            createProductUseCase,
            updateProductUseCase,
            deleteProductUseCase
        )
    }
}
