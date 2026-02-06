package com.ameth.voltio.features.products.presentation.screens.UiState

import com.ameth.voltio.features.products.domain.entities.Product

data class ProductFormUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null,
    val currentProduct: Product? = null
)
