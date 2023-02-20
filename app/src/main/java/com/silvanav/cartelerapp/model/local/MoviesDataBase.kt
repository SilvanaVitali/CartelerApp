package com.silvanav.cartelerapp.model.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.silvanav.cartelerapp.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDataBase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}

class MovieApplication: Application() {

    companion object {
        var movieDatabase: MoviesDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        movieDatabase = Room
            .databaseBuilder(this,MoviesDataBase::class.java, "movie_db")
            .build()
    }

}