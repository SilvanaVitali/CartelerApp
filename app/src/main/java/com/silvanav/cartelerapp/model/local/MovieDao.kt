package com.silvanav.cartelerapp.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.silvanav.cartelerapp.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movieList: List<Movie>)

    @Query("SELECT * FROM movie")
    fun getAllMovies(): LiveData<List<Movie>>

}