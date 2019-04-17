package ie.redstudio.dzoneapplicationone.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Łukasz on 18/01/2019.
 */

@Database(entities = arrayOf(Movie::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}