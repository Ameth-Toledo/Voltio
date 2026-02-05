package com.ameth.voltio.core.di

import android.content.Context
import com.ameth.voltio.core.network.VoltioApi
import com.ameth.voltio.features.login.data.repositories.AuthRepositoryImpl
import com.ameth.voltio.features.login.domain.repositories.IAuthRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(context: Context) {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://voltio.ameth.shop/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val voltioApi: VoltioApi by lazy {
        retrofit.create(VoltioApi::class.java)
    }

    val authRepository: IAuthRepository by lazy {
        AuthRepositoryImpl(voltioApi)
    }
}