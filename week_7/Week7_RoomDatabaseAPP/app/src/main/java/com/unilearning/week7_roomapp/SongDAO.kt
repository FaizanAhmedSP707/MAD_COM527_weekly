package com.unilearning.week7_roomapp

import androidx.room.*

@Dao
interface SongDAO{

    @Query("SELECT * FROM hits WHERE id=:id")
    fun getSongById(id: Long) : Song?

    @Insert
    fun addSong(songObj: Song) : Long

    @Update
    fun updateSong(song: Song) : Int

    @Delete
    fun deleteSong(songOBJ: Song) : Int
}