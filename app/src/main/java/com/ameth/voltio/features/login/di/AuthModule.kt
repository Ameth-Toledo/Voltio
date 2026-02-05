package com.ameth.voltio.features.login.di

import com.ameth.voltio.core.di.AppContainer
import com.ameth.voltio.features.login.domain.usecases.AuthUseCase
import com.ameth.voltio.features.login.presentation.viewmodels.LoginViewModelFactory

class AuthModule(
    private val appContainer: AppContainer
) {

    private fun provideAuthUseCase(): AuthUseCase {
        return AuthUseCase(appContainer.authRepository)
    }

    fun provideLoginViewModelFactory(): LoginViewModelFactory {
        return LoginViewModelFactory(
            authUseCase = provideAuthUseCase()
        )
    }
}