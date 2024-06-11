package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.EntityInterface

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDAO {
    @Query("SELECT * FROM Product")
    fun getAllProduct(): Flow<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(productEntity: ProductEntity)
}