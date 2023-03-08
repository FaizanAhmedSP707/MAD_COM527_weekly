package com.unilearning.week7_roomapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Song::class), version = 1, exportSchema = false)
public abstract class HittasticDatabase: RoomDatabase() {
    abstract fun songDao(): SongDAO

    companion object {
        private var instance: HittasticDatabase? = null

        fun getDatabase(ctx:Context) : HittasticDatabase {
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