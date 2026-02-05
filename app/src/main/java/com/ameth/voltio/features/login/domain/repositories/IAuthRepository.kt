package com.ameth.voltio.features.login.domain.repositories

import com.ameth.voltio.features.login.data.datasource.remote.model.AuthRequest
import com.ameth.voltio.features.login.data.datasource.remote.model.LoginRequest
import com.ameth.voltio.features.login.data.datasource.remote.model.AuthResponse
import com.ameth.voltio.features.login.data.datasource.remote.model.MessageResponse
import com.ameth.voltio.features.login.data.datasource.remote.model.ProfileResponse

interface IAuthRepository {
    suspend fun login(loginRequest: LoginRequest): AuthResponse
    suspend fun register(authRequest: AuthRequest): AuthResponse
    suspend fun logout(): MessageResponse
    suspend fun refreshToken(): MessageResponse
    suspend fun getProfile(): ProfileResponse
    suspend fun verifyToken(): ProfileResponse
}