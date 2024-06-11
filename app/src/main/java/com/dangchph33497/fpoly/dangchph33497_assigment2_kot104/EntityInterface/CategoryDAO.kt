package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.EntityInterface

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.AccountEntity
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDAO {
    @Query("SELECT * FROM Category")
    fun getALlCategory(): Flow<List<CategoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCategory(categoryEntity: CategoryEntity)
}