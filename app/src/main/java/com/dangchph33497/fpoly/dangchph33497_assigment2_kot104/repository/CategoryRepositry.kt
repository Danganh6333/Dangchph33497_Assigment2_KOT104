package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository

import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.R
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.CategoryEntity
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.roomDatabase.AppDatabase

class CategoryRepositry(val categoryDB : AppDatabase) {
    fun getAllCategory() :List<CategoryEntity> {
        return listOf(
            CategoryEntity(0,"Popular",R.drawable.baseline_star_24),
            CategoryEntity(1, "Chair", R.drawable.outline_chair_alt_24),
            CategoryEntity(2, "Table", R.drawable.outline_table_bar_24),
            CategoryEntity(3, "Armchair", R.drawable.outline_chair_24),
            CategoryEntity(4, "Bed", R.drawable.outline_bed_24)
        )

    }
    suspend fun insertCategories(categories: List<CategoryEntity>) {
        categories.forEach { categoryDB.categoryDao().addCategory(it) }
    }
}