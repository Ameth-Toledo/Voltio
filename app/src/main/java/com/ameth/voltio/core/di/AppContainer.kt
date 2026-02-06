package com.ameth.voltio.core.di

import android.content.Context
import com.ameth.voltio.core.network.VoltioApi
import com.ameth.voltio.features.login.data.repositories.AuthRepositoryImpl
import com.ameth.voltio.features.login.domain.repositories.IAuthRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(private val context: Context) {

    val sessionManager: TokenManager by lazy {
        TokenManager(context)
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://voltio.ameth.shop/api/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val voltioApi: VoltioApi by lazy {
        retrofit.create(VoltioApi::class.java)
    }

    val authRepository: IAuthRepository by lazy {
        AuthRepositoryImpl(voltioApi)
    }
}