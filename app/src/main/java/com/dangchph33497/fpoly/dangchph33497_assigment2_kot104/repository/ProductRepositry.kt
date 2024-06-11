package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository

import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.R
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.ProductEntity
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.roomDatabase.AppDatabase

class ProductRepositry(val productDB : AppDatabase) {
    fun getAllProducts() :List<ProductEntity> {
        return listOf(
            ProductEntity(1, "Black Simple Lamp", "",12.0f, R.drawable.image2, 1),
            ProductEntity(2, "Minimal Stand", "",25.0f, R.drawable.image4, 2),
            ProductEntity(3, "Coffee Chair", "",20.0f, R.drawable.image1, 3),
            ProductEntity(4, "Simple Desk", "",50.0f,R.drawable.image5,4)
        )
    }
    suspend fun insertProducts(products: List<ProductEntity>) {
        products.forEach {  productDB.productDao().addProduct(it)  }
    }
}