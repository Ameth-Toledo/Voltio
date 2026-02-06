package com.ameth.voltio.features.products.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ameth.voltio.features.products.domain.usecase.*

@Suppress("UNCHECKED_CAST")
class ProductViewModelFactory(
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val createProductUseCase: CreateProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(
                    getProductsUseCase,
                    deleteProductUseCase
                ) as T
            }
            modelClass.isAssignableFrom(ProductFormViewModel::class.java) -> {
                ProductFormViewModel(
                    createProductUseCase,
                    updateProductUseCase,
                    getProductByIdUseCase
                ) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
