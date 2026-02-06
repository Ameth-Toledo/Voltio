package com.ameth.voltio.features.products.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ameth.voltio.features.products.domain.usecase.DeleteProductUseCase
import com.ameth.voltio.features.products.domain.usecase.GetProductsUseCase
import com.ameth.voltio.features.products.presentation.screens.UiState.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val deleteProductUseCase: DeleteProductUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    fun loadProducts() {
        _uiState.update { it.copy(isLoading = true, error = null) }
        viewModelScope.launch {
            val result = getProductsUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { products ->
                        currentState.copy(isLoading = false, products = products, error = null)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }

    fun deleteProduct(id: Int) {
        viewModelScope.launch {
            val result = deleteProductUseCase(id)
            result.onSuccess {
                loadProducts()
            }.onFailure { error ->
                _uiState.update { it.copy(error = "No se pudo eliminar: ${error.message}") }
            }
        }
    }

}
