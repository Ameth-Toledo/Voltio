package com.ameth.voltio.features.login.presentation.screens

import com.ameth.voltio.features.login.domain.entities.Auth

data class LoginUiState(
    val isLoading: Boolean = false,
    val user: Auth? = null,
    val error: String? = null,
    val isAuthenticated: Boolean = false
)