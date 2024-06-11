package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.Date

@Entity(
    foreignKeys = [ForeignKey(
        entity = AccountEntity::class,
        parentColumns = ["Email"],
        childColumns = ["Email"],
        onDelete = ForeignKey.CASCADE,
    )],
    tableName = "Bill"
)

@TypeConverters(DateConverter::class)
data class BillEntity(
    @PrimaryKey @ColumnInfo(name = "BillID") var billID: Int = 0,
    @ColumnInfo(name = "Date") var date: Date,
    @ColumnInfo(name = "Email") var email: String?
)

class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}