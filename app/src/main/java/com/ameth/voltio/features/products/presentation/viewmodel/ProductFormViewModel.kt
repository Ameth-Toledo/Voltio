package com.ameth.voltio.features.products.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ameth.voltio.features.products.data.datasource.remote.model.CreateProductRequest
import com.ameth.voltio.features.products.domain.usecase.CreateProductUseCase
import com.ameth.voltio.features.products.domain.usecase.GetProductByIdUseCase
import com.ameth.voltio.features.products.domain.usecase.UpdateProductUseCase
import com.ameth.voltio.features.products.presentation.screens.UiState.ProductFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductFormViewModel(
    private val createProductUseCase: CreateProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val getProductByIdUseCase: GetProductByIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductFormUiState())
    val uiState = _uiState.asStateFlow()

    fun loadProductForEdit(id: Int) {
        if (id == -1) return
        viewModelScope.launch {
            val result = getProductByIdUseCase(id)
            result.onSuccess { product ->
                _uiState.update { it.copy(currentProduct = product) }
            }
        }
    }

    fun saveProduct(id: Int, request: CreateProductRequest) {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val result = if (id == -1) {
                createProductUseCase(request)
            } else {
                updateProductUseCase(id, request)
            }

            _uiState.update { state ->
                result.fold(
                    onSuccess = { state.copy(isLoading = false, isSuccess = true) },
                    onFailure = { error -> state.copy(isLoading = false, error = error.message) }
                )
            }
        }
    }
}
