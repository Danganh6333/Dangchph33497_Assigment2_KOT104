package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.EntityInterface

import androidx.room.Dao
import androidx.room.Query
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.BillEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BillDAO {
    @Query("SELECT * FROM Bill")
    fun getALlBills(): Flow<List<BillEntity>>
}