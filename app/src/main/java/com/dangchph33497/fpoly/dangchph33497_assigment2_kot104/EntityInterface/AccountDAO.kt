package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.EntityInterface

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.AccountEntity


@Dao
interface AccountDAO {
    @Insert
    suspend fun addAccount(account : AccountEntity)

    @Query("SELECT EXISTS(SELECT * FROM Account WHERE Email = :email)")
    suspend fun is_taken(email : String) : Boolean

    @Query("SELECT EXISTS(SELECT * FROM Account WHERE Email = :email AND Password = :password )")
    suspend fun login(email: String,password:String) : Boolean

}