package com.ameth.voltio.features.login.domain.usecases

import com.ameth.voltio.features.login.data.datasource.remote.model.LoginRequest
import com.ameth.voltio.features.login.domain.entities.Auth
import com.ameth.voltio.features.login.domain.repositories.IAuthRepository
import com.ameth.voltio.features.login.data.datasource.remote.mapper.toDomain

class AuthUseCase(
    private val repository: IAuthRepository
) {
    suspend operator fun invoke(loginRequest: LoginRequest): Result<Pair<Auth, String>> {
        return try {
            val response = repository.login(loginRequest)
            val user = response.user.toDomain()
            val token = response.accessToken
            Result.success(Pair(user, token))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}