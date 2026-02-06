package com.ameth.voltio.features.login.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ameth.voltio.features.login.domain.usecases.AuthUseCase
import com.ameth.voltio.features.login.data.datasource.remote.model.LoginRequest
import com.ameth.voltio.features.login.presentation.screens.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun login(email: String, password: String) {
        _uiState.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            val loginRequest = LoginRequest(email, password)
            val result = authUseCase(loginRequest)

            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { (user, token) ->
                        currentState.copy(
                            isLoading = false,
                            user = user,
                            isAuthenticated = true,
                            error = null
                        )
                    },
                    onFailure = { error ->
                        currentState.copy(
                            isLoading = false,
                            error = error.message ?: "Error desconocido",
                            isAuthenticated = false
                        )
                    }
                )
            }
        }
    }

    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }
}