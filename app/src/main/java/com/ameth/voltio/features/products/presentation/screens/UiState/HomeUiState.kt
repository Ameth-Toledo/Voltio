package com.ameth.voltio.features.products.presentation.screens.UiState

import com.ameth.voltio.features.products.domain.entities.Product

data class HomeUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
