package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Account")
data class AccountEntity(
    @PrimaryKey @ColumnInfo(name = "Email") var email: String,
    @ColumnInfo(name = "Password") var password: String?,
    @ColumnInfo(name = "FullName") var fullName: String?,
)