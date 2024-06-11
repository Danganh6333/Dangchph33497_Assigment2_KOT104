package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.*
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.EntityInterface.*

@Database(
    entities = [
        AccountEntity::class,
        BillEntity::class,
        BillDetailsEntity::class,
        ProductEntity::class,
        CategoryEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDAO
    abstract fun billDao(): BillDAO
    abstract fun billDetailsDao(): BillDetailsDAO
    abstract fun productDao(): ProductDAO
    abstract fun categoryDao(): CategoryDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    ).build()
                }
                return instance
            }
        }
    }
}
