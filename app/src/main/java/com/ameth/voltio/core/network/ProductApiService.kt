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
    suspend fun getProducts(
        @Header("Authorization") token: String,
        @Header("Cookie") cookie: String
    ): List<ProductDto>

    @GET("products/{id}")
    suspend fun getProductById(
        @Header("Authorization") token: String,
        @Header("Cookie") cookie: String,
        @Path("id") id: Int
    ): ProductDto

    // Para crear con imagen, DEBE ser Multipart
    @Multipart
    @POST("products")
    suspend fun createProduct(
        @Header("Authorization") token: String,
        @Header("Cookie") cookie: String,
        @Part("sku") sku: RequestBody,
        @Part("nombre") nombre: RequestBody,
        @Part("descripcion") descripcion: RequestBody?,
        @Part("precio_venta") precio_venta: RequestBody,
        @Part("stock_actual") stock_actual: RequestBody,
        @Part("id_categoria") id_categoria: RequestBody?,
        @Part imagen: MultipartBody.Part? = null // Esto llega como req.file en Express
    ): ProductDto

    @Multipart
    @PUT("products/{id}")
    suspend fun updateProduct(
        @Header("Authorization") token: String,
        @Header("Cookie") cookie: String,
        @Path("id") id: Int,
        @Part("sku") sku: RequestBody,
        @Part("nombre") nombre: RequestBody,
        @Part("descripcion") descripcion: RequestBody?,
        @Part("precio_venta") precio_venta: RequestBody,
        @Part("stock_actual") stock_actual: RequestBody,
        @Part("id_categoria") id_categoria: RequestBody?,
        @Part imagen: MultipartBody.Part? = null
    ): ProductDto
    @DELETE("products/{id}")
    suspend fun deleteProduct(
        @Header("Authorization") token: String,
        @Header("Cookie") cookie: String,
        @Path("id") id: Int
    ): Response<Unit>
}