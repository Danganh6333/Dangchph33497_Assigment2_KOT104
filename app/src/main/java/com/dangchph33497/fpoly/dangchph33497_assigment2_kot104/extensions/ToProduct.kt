package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.extensions

import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.ProductEntity
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.model.Product

fun ProductEntity.toProduct(): Product {
    return Product(
        maSP = this.productID,
        tenSP = this.productName ?: "",
        donGia = this.price ?: 0.0f,
        anh = this.image ?: 0,
        maTheLoai = this.cateID ?: 0
    )
}
