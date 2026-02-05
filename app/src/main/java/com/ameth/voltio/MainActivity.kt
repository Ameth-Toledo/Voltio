package com.ameth.voltio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ameth.voltio.core.di.AppContainer
import com.ameth.voltio.features.login.di.AuthModule
import com.ameth.voltio.core.navigation.NavigationWrapper
import com.example.compose.AppTheme

class MainActivity : ComponentActivity() {
    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = AppContainer(this)
        val authModule = AuthModule(appContainer)

        enableEdgeToEdge()
        setContent {
            AppTheme {
                NavigationWrapper()
            }
        }
    }
}