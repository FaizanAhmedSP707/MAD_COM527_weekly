package com.unilearning.week7_roomapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Student::class), version = 1, exportSchema = false)
public abstract class HittasticDatabase: RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        private var instance: StudentDatabase? = null

        fun getDatabase(ctx:Context) : StudentDatabase {
            var tmpInstance = instance
            if(tmpInstance == null) {
                tmpInstance = Room.databaseBuilder(
                    ctx.applicationContext,
                    HittasticDatabase::class.java,
                    "hittasticDatabase"
                ).build()
                instance = tmpInstance
            }
            return tmpInstance
        }
    }
}