package com.miltonvaz.voltio_1.features.products.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.miltonvaz.voltio_1.core.network.TokenManager
import com.miltonvaz.voltio_1.features.products.domain.usecase.*
@Suppress("UNCHECKED_CAST")
class ProductViewModelFactory(
    private val productId: Int = -1, // Añade este parámetro con valor por defecto
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val createProductUseCase: CreateProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
    private val tokenManager: TokenManager
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(
                    getProductsUseCase,
                    deleteProductUseCase,
                    tokenManager
                ) as T
            }
            modelClass.isAssignableFrom(ProductFormViewModel::class.java) -> {
                ProductFormViewModel(
                    productId,
                    createProductUseCase,
                    updateProductUseCase,
                    getProductByIdUseCase,
                    tokenManager
                ) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}