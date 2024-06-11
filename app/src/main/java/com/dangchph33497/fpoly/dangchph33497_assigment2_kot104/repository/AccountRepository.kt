package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository

import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.AccountEntity
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.roomDatabase.AppDatabase

class AccountRepository(val accountDB : AppDatabase) {
    suspend fun signUp(accountEntity: AccountEntity){
        accountDB.accountDao().addAccount(accountEntity)
    }
    suspend fun signIn(email:String, password :String ) : Boolean {
        return accountDB.accountDao().login(email,password)
    }
    suspend fun isEmailTaken(email: String): Boolean {
        return accountDB.accountDao().is_taken(email)
    }
}