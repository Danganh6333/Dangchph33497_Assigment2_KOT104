package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.extensions


import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.CategoryEntity
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.ProductEntity
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.model.Product
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.model.Type

fun CategoryEntity.toCategory(): Type {
    return Type(
        CateID = this.cateID,
        CateIcon =  this.cateIcon ?: 0,
        CateName =  this.cateName ?:""
    )
}
