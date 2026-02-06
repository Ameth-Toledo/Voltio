package com.ameth.voltio.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Register

@Serializable
object Home

@Serializable
data class ProductDetailArg(val id: Int)

@Serializable
data class ProductFormArg(val id: Int = -1)