package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "BillDetails",
    primaryKeys = ["ProductID","BillID"],
    foreignKeys = [
        ForeignKey(
            entity = BillEntity::class,
            parentColumns = ["BillID"],
            childColumns = ["BillID"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ProductEntity::class,
            parentColumns = ["ProductID"],
            childColumns = ["ProductID"],
            onDelete = ForeignKey.CASCADE
        )
    ],
)
data class BillDetailsEntity(
    @ColumnInfo(name = "BillID", index = true) var billID: Int = 0,
    @ColumnInfo(name = "ProductID", index = true) var productID: Int = 0,
    @ColumnInfo(name = "Quantity") var quantity: Int = 0,
)
