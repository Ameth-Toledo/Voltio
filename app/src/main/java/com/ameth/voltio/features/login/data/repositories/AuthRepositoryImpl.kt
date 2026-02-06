package com.ameth.voltio.features.login.data.repositories

import com.ameth.voltio.core.network.VoltioApi
import com.ameth.voltio.features.login.data.datasource.remote.model.AuthRequest
import com.ameth.voltio.features.login.data.datasource.remote.model.LoginRequest
import com.ameth.voltio.features.login.data.datasource.remote.model.AuthResponse
import com.ameth.voltio.features.login.data.datasource.remote.model.MessageResponse
import com.ameth.voltio.features.login.data.datasource.remote.model.ProfileResponse
import com.ameth.voltio.features.login.domain.repositories.IAuthRepository

class AuthRepositoryImpl(
    private val api: VoltioApi
) : IAuthRepository {

    override suspend fun login(loginRequest: LoginRequest): AuthResponse {
        return api.login(loginRequest)
    }

    override suspend fun register(authRequest: AuthRequest): AuthResponse {
        return api.register(authRequest)
    }

    override suspend fun logout(): MessageResponse {
        return api.logout()
    }

    override suspend fun refreshToken(): MessageResponse {
        return api.refreshToken()
    }

    override suspend fun getProfile(): ProfileResponse {
        return api.getProfile()
    }

    override suspend fun verifyToken(): ProfileResponse {
        return api.verifyToken()
    }
}