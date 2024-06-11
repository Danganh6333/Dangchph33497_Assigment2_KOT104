package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.EntityInterface

import androidx.room.Dao
import androidx.room.Query
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.BillDetailsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BillDetailsDAO {
    @Query("SELECT * FROM BillDetails")
    fun getALlBillDetails(): Flow<List<BillDetailsEntity>>
}