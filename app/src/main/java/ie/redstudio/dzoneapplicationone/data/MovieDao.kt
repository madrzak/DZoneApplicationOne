package ie.redstudio.dzoneapplicationone.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by Łukasz on 18/01/2019.
 */
@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAll(): List<Movie>

    @Insert
    fun insert(item: Movie)
}