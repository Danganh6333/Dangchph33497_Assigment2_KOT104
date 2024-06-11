package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = ["CateID"],
        childColumns = ["CateID"],
        onDelete = ForeignKey.CASCADE
    )],
    tableName = "Product"
)
data class ProductEntity (
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "ProductID") var productID : Int = 0,
    @ColumnInfo(name = "ProductName") var productName : String?,
    @ColumnInfo(name = "Description") var description : String?,
    @ColumnInfo(name = "Price") var price : Float?,
    @ColumnInfo(name = "Image") var image : Int?,
    @ColumnInfo(name = "CateID") var cateID : Int?
)
