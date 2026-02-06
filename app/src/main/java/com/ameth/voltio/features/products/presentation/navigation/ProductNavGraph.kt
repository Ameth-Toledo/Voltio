package com.ameth.voltio.features.products.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.ameth.voltio.core.navigation.FeatureNavGraph
import com.ameth.voltio.core.navigation.Home
import com.ameth.voltio.core.navigation.ProductDetailArg
import com.ameth.voltio.core.navigation.ProductFormArg
import com.ameth.voltio.features.products.presentation.screens.HomeScreen
import com.ameth.voltio.features.products.presentation.viewmodel.ProductViewModelFactory

class ProductNavGraph(
    private val viewModelFactory: ProductViewModelFactory
) : FeatureNavGraph {

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    ) {
        navGraphBuilder.composable<Home> {
            HomeScreen(
                factory = viewModelFactory,
                onAddProduct = {
                    navController.navigate(ProductFormArg(id = -1))
                },
                onEditProduct = { id ->
                    navController.navigate(ProductFormArg(id = id))
                }
            )
        }

        navGraphBuilder.composable<ProductFormArg> { backStackEntry ->
            val args = backStackEntry.toRoute<ProductFormArg>()
            // Implement ProductFormScreen call if needed
        }
    }
}
