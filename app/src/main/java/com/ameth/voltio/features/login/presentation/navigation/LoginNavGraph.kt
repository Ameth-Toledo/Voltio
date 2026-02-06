package com.ameth.voltio.features.login.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.ameth.voltio.core.navigation.FeatureNavGraph
import com.ameth.voltio.core.navigation.Home
import com.ameth.voltio.core.navigation.Login
import com.ameth.voltio.features.login.presentation.screens.LoginScreen
import com.ameth.voltio.features.login.presentation.viewmodels.LoginViewModelFactory

class LoginNavGraph(
    private val loginViewModelFactory: LoginViewModelFactory
) : FeatureNavGraph {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    ) {
        navGraphBuilder.composable<Login> {
            LoginScreen(
                factory = loginViewModelFactory,
                onBackClick = {
                    navController.popBackStack()
                },
                onRegisterClick = {
                    // TODO: navController.navigate(Register)
                },
                onLoginSuccess = {
                    // TODO: Cuando tengas Home, descomenta esto:
                    // navController.navigate(Home) {
                    //     popUpTo<Login> { inclusive = true }
                    // }
                }
            )
        }
    }
}