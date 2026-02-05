package com.ameth.voltio.features.login.data.datasource.remote.model

data class AuthResponse(
    val message: String,
    val accessToken: String,
    val refreshToken: String,
    val user: UserDto
)

data class UserDto(
    val id: Int,
    val name: String,
    val secondname: String?,
    val lastname: String,
    val secondlastname: String?,
    val email: String,
    val phone: String?,
    val image_profile: String?,
    val role: String,
    val created_at: String
)

data class ProfileResponse(
    val user: UserDto
)

data class MessageResponse(
    val message: String
)