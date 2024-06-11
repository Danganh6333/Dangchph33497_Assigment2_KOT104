package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities



import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Category")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "CateID") var cateID : Int = 0,
    @ColumnInfo(name = "CateName") var cateName : String?,
    @ColumnInfo(name = "CateIcon") var cateIcon : Int?
)