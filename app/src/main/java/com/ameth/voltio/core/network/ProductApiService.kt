package com.ameth.voltio.core.network

import com.ameth.voltio.features.products.data.datasource.remote.model.CreateProductRequest
import com.ameth.voltio.features.products.data.datasource.remote.model.ProductDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductApiService {

    @GET("products")
    suspend fun getProducts(): List<ProductDto>

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): ProductDto

    @GET("products/category/{id_categoria}")
    suspend fun getProductsByCategory(@Path("id_categoria") categoryId: Int): List<ProductDto>

    @POST("products")
    suspend fun createProduct(@Body request: CreateProductRequest): ProductDto

    @PUT("products/{id}")
    suspend fun updateProduct(@Path("id") id: Int, @Body request: CreateProductRequest): ProductDto

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") id: Int): Response<Unit>
}