package com.ameth.voltio.core.network

import com.ameth.voltio.features.login.data.datasource.remote.model.AuthRequest
import com.ameth.voltio.features.login.data.datasource.remote.model.LoginRequest
import com.ameth.voltio.features.login.data.datasource.remote.model.AuthResponse
import com.ameth.voltio.features.login.data.datasource.remote.model.MessageResponse
import com.ameth.voltio.features.login.data.datasource.remote.model.ProfileResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface VoltioApi {

    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): AuthResponse

    @POST("auth/register")
    suspend fun register(@Body authRequest: AuthRequest): AuthResponse

    @POST("auth/logout")
    suspend fun logout(): MessageResponse

    @POST("auth/refresh")
    suspend fun refreshToken(): MessageResponse

    @GET("auth/profile")
    suspend fun getProfile(): ProfileResponse

    @GET("auth/verify")
    suspend fun verifyToken(): ProfileResponse
}